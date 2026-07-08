package br.com.dgm.msavaliadorcredito.domain.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CustomerCard {

    private String holdernName;
    private String cardBrand;
    private BigDecimal approvedLimit;

}
