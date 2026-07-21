package br.com.dgm.msavaliadorcredito.application.service;

import br.com.dgm.msavaliadorcredito.application.exceptions.CustomerDataNotFoundException;
import br.com.dgm.msavaliadorcredito.application.exceptions.ErrorCardRequestException;
import br.com.dgm.msavaliadorcredito.application.exceptions.ErrorConnectionMicroserviceException;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerCardMapper;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerDataMapper;
import br.com.dgm.msavaliadorcredito.domain.model.*;
import br.com.dgm.msavaliadorcredito.domain.model.enuns.CardBrand;
import br.com.dgm.msavaliadorcredito.infra.client.CardResourceClient;
import br.com.dgm.msavaliadorcredito.infra.client.CustomerResouceClient;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CardCustomerRS;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CardRS;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import br.com.dgm.msavaliadorcredito.infra.mqueue.CardIssuanceRequestPublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final CustomerResouceClient customerResouceClient;
    private final CardResourceClient cardResourceClient;
    private final CardIssuanceRequestPublisher cardIssuanceRequestPublisher;

    public CustomerStatus getCustomerStatus(String taxId) {
        try {
            var customerData = getCustomerDataOrThrow(taxId);
            var customerCard = getCustomerCardsOrNull(taxId);
            return CustomerStatus.builder()
                    .customerData(customerData)
                    .customerCard(customerCard)
                    .build();

        } catch (FeignException.NotFound ex) {
            throw new CustomerDataNotFoundException(taxId);
        } catch (FeignException | ResourceAccessException ex) {
            throw new ErrorConnectionMicroserviceException(
                    "Falha ao comunicar com microserviços externos",
                    ex
            );
        }
    }

    public EvaluationCustomer calculateEvaluation(String taxId, BigDecimal income) {
        try {
            var customer = getCustomerDataOrThrow(taxId);
            List<CardRS> cards = Optional.ofNullable(cardResourceClient.getCardListByIncome(income).getBody())
                    .orElse(List.of());

            List<ApprovedCard> approvedCards = cards.stream()
                    .map(card -> toApprovedCard(card, income, customer.getAge()))
                    .toList();

            EvaluationCustomer evaluationCustomer = new EvaluationCustomer();
            evaluationCustomer.setApprovedCards(approvedCards);
            return evaluationCustomer;
        } catch (FeignException.NotFound ex) {
            throw new CustomerDataNotFoundException(taxId);
        } catch (FeignException | ResourceAccessException ex) {
            throw new ErrorConnectionMicroserviceException(
                    "Falha ao comunicar com microserviços externos",
                    ex
            );
        }
    }

    public CardIssuanceProtocol cardIssuanceRequest(CardIssuanceRequestData data) {
        try {
            cardIssuanceRequestPublisher.cardResquet(data);
            var protocol = UUID.randomUUID().toString();
            return new CardIssuanceProtocol(protocol);
        } catch (Exception e) {
            throw new ErrorCardRequestException(e.getMessage());
        }
    }

    private ApprovedCard toApprovedCard(CardRS card, BigDecimal income, Integer age) {
        ApprovedCard approvedCard = new ApprovedCard();
        approvedCard.setHolderName(card.holderName());
        approvedCard.setCardBrand(CardBrand.from(card.cardBrand()));
        approvedCard.setCreditLimit(calculateLimit(card.creditLimit(), income, age));
        return approvedCard;
    }

    private BigDecimal calculateLimit(BigDecimal baseLimit, BigDecimal income, Integer age) {
        if (baseLimit == null || income == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal ageFactor = resolveAgeFactor(age);
        BigDecimal incomeFactor = income.divide(new BigDecimal("1000"), 4, RoundingMode.HALF_UP);
        return baseLimit
                .multiply(incomeFactor)
                .multiply(ageFactor)
                .setScale(3, RoundingMode.HALF_UP);
    }

    private BigDecimal resolveAgeFactor(Integer age) {
        if (age == null) {
            return BigDecimal.ONE;
        }

        if (age <= 25) {
            return new BigDecimal("0.50");
        }
        if (age <= 35) {
            return new BigDecimal("0.75");
        }
        if (age <= 50) {
            return BigDecimal.ONE;
        }
        return new BigDecimal("1.25");
    }

    private CustomerData getCustomerDataOrThrow(String taxId) {
        ResponseEntity<CustomerResponseDTO> response = customerResouceClient.getCustomerByTaxId(taxId);
        var body = Optional.ofNullable(response.getBody())
                .orElseThrow(() -> new CustomerDataNotFoundException(taxId));
        return CustomerDataMapper.toDomain(body);
    }

    private List<CustomerCard> getCustomerCardsOrNull(String taxId) {
        ResponseEntity<List<CardCustomerRS>> response = cardResourceClient.getCardCustumerByTaxId(taxId);
        return Optional.ofNullable(response.getBody())
                .map(CustomerCardMapper::toDomain)
                .orElse(null);
    }
}
