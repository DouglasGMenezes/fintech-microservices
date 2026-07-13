package br.com.dgm.msavaliadorcredito.application.mapper;

import br.com.dgm.msavaliadorcredito.application.representation.CustomerCardDTO;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerDataDTO;
import br.com.dgm.msavaliadorcredito.application.representation.CustomerStatusDTO;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;
import java.util.List;

public class CustomerStatusMapper {

    public static CustomerStatusDTO toDto(CustomerStatus customerStatus) {
        CustomerDataDTO customerDataDTO = new CustomerDataDTO(
                customerStatus.getCustomerData().getId(),
                customerStatus.getCustomerData().getName()
        );
        List<CustomerCardDTO> customerCardDTOs = customerStatus.getCustomerCard()
                .stream()
                .map(card -> new CustomerCardDTO(
                        card.getHoldernName(),
                        card.getCardBrand(),
                        card.getApprovedLimit()
              ))
                .toList();
        return new CustomerStatusDTO(
                customerDataDTO,
                customerCardDTOs
        );
    }



}
