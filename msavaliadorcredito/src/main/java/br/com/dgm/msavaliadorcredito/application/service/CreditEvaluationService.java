package br.com.dgm.msavaliadorcredito.application.service;

import br.com.dgm.msavaliadorcredito.application.exceptions.CustomerDataNotFoundException;
import br.com.dgm.msavaliadorcredito.application.exceptions.ErrorConnectionMicroserviceException;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerCardMapper;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerDataMapper;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import br.com.dgm.msavaliadorcredito.infra.client.CardResourceClient;
import br.com.dgm.msavaliadorcredito.infra.client.CustomerResouceClient;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CardCustomerRS;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final CustomerResouceClient customerResouceClient;
    private final CardResourceClient cardResourceClient;

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
