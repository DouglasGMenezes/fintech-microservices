package br.com.dgm.msavaliadorcredito.application.mapper;

import br.com.dgm.msavaliadorcredito.domain.model.CustomerData;
import br.com.dgm.msavaliadorcredito.infra.client.dto.CustomerResponseDTO;

public class CustomerDataMapper {

    public static CustomerData toDomain(CustomerResponseDTO dto) {
        CustomerData customerData = new CustomerData();
        customerData.setId(dto.id());
        customerData.setName(dto.name());
        customerData.setAge(dto.age());
        return customerData;
    }

}
