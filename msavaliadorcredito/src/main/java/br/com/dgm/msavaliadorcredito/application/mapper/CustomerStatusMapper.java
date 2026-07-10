package br.com.dgm.msavaliadorcredito.application.mapper;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerStatusDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;

public class CustomerStatusMapper() {

    public static CustomerStatusDTO toDto(CustomerStatus customerStatus) {
        return new CustomerStatusDTO(
                customerStatus.getCustomerData().getId(),
                customerStatus.getCustomerCard()
        );
    }
//
//    public static CardCustomerRS toCardCustomerDTO(CardCustomer cardCustomer) {
//        return new CardCustomerRS(
//                cardCustomer.getCard().getHolderName(),
//                cardCustomer.getCard().getCardBrand().toString(),
//                cardCustomer.getApprovedLimit()
//        );
//    }
//
}
