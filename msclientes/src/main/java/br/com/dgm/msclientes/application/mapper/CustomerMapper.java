package br.com.dgm.msclientes.application.mapper;

import br.com.dgm.msclientes.application.representation.CustomerRequestDTO;
import br.com.dgm.msclientes.application.representation.CustomerResponseDTO;
import br.com.dgm.msclientes.domain.model.Customer;


public class CustomerMapper {

    public CustomerMapper(){}

    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.name());
        customer.setTaxId(dto.taxId());
        customer.setAge(dto.age());
        return customer;
    }

    public static CustomerResponseDTO toResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getTaxId(),
                customer.getName(),
                customer.getAge()
        );
    }
// usando builder
    public static CustomerResponseDTO toRsUpdadeDto(Customer customer) {
        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .taxId(customer.getTaxId())
                .name(customer.getName())
                .age(customer.getAge())
                .build();
    }

}
