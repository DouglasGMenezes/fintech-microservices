package br.com.dgm.msavaliadorcredito.application.service;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerDataDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import br.com.dgm.msavaliadorcredito.infra.client.CustomerResouceClient;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditEvaluationService {

    private final CustomerResouceClient customerResouceClient;

    public CustomerStatus getCustomerStatus(String taxId) {
        ResponseEntity<CustomerData> rsEntity = customerResouceClient.getCustomerByTaxId(taxId);
        return CustomerStatus.builder()
                .customerData(rsEntity.getBody())
                .build();
    }

}
