package br.com.dgm.msavaliadorcredito.domain.model;

import br.com.dgm.msavaliadorcredito.domain.model.enuns.CardBrand;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ApprovedCard {

    private String holderName;
    private CardBrand cardBrand;
    private BigDecimal creditLimit;

}
