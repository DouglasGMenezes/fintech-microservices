package br.com.dgm.msavaliadorcredito.application.mapper;

import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CardCustomerRS;

import java.util.List;

public class CustomerCardMapper {

    public static CustomerCard toDomain(CardCustomerRS customerDto) {
        return CustomerCard.builder()
                .holderName(customerDto.holderName())
                .cardBrand(customerDto.cardBrand())
                .approvedLimit(customerDto.approvedLimit())
                .build();
    }

    public static List<CustomerCard> toDomain(List<CardCustomerRS> cards) {
        return cards.stream()
                .map(CustomerCardMapper::toDomain)
                .toList();
    }

}
