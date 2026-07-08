package br.com.dgm.msavaliadorcredito.application.mapper;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerCardDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;

public class CustomerCardMapper {

    public CustomerCard toEntity(CustomerCardDTO customerDto) {
        return CustomerCard.builder()
                .holdernName(customerDto.holdernName())
                .cardBrand(customerDto.cardBrand())
                .approvedLimit(customerDto.approvedLimit())
                .build();
    }

    public CustomerCardDTO toDTO() {
        return null;
    }

}
