package br.com.dgm.msavaliadorcredito.application.representation;

import java.util.List;

public record CustomerStatusDTO(
        CustomerDataDTO customerData,
        List<CustomerCardDTO> customerCard
) {
}
