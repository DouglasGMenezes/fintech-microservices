package br.com.dgm.msavaliadorcredito.application.service;

import br.com.dgm.msavaliadorcredito.application.mapper.CustomerDataMapper;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerDataDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import br.com.dgm.msavaliadorcredito.infra.client.CustomerResouceClient;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final CustomerResouceClient customerResouceClient;

    public CustomerStatus getCustomerStatus(String taxId) {
        ResponseEntity<CustomerResponseDTO> response = customerResouceClient.getCustomerByTaxId(taxId);
        CustomerData customerData = CustomerDataMapper.toDomain(
                Optional.ofNullable(response.getBody())
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"))
        );
        return CustomerStatus.builder()
                .customerData(customerData)
                .build();
    }

}
