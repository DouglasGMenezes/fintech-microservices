package br.com.dgm.msavaliadorcredito.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerStatus {

    private CustomerData customerData;
    private List<CustomerCard> customerCard;

}
