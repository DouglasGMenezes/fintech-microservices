package br.com.dgm.msavaliadorcredito.application.representation;

import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;

import java.util.List;

public record CustomerStatusDTO(
        CustomerDataDTO customerData,
        List<CustomerCardDTO> customerCard
) {
}
