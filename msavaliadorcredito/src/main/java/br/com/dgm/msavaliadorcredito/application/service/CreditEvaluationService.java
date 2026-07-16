package br.com.dgm.msavaliadorcredito.application.service;

import br.com.dgm.msavaliadorcredito.application.mapper.CustomerCardMapper;
import br.com.dgm.msavaliadorcredito.application.mapper.CustomerDataMapper;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerDataDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import br.com.dgm.msavaliadorcredito.infra.client.CardResourceClient;
import br.com.dgm.msavaliadorcredito.infra.client.CustomerResouceClient;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CardCustomerRS;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final CustomerResouceClient customerResouceClient;
    private final CardResourceClient cardResourceClient;

    public CustomerStatus getCustomerStatus(String taxId) {
        ResponseEntity<CustomerResponseDTO> customerRsDto = customerResouceClient.getCustomerByTaxId(taxId);
        CustomerData customerData = CustomerDataMapper.toDomain(
                Optional.ofNullable(customerRsDto.getBody())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"))
        );
        ResponseEntity<List<CardCustomerRS>> cardCustomerRsDto = cardResourceClient.getCardCustumerByTaxId(taxId);
        List<CustomerCard> customerCard = CustomerCardMapper.toDomain(
                Optional.ofNullable(cardCustomerRsDto.getBody())
                        .orElseThrow(() -> new RuntimeException("Cartao não encontrado"))
        );
        return CustomerStatus.builder()
                .customerData(customerData)
                .customerCard(customerCard)
                .build();
    }

}
