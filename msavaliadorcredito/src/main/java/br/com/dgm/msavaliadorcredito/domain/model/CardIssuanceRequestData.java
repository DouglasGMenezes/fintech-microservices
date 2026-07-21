package br.com.dgm.msavaliadorcredito.domain.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CardIssuanceRequestData {

    private Long cardId;
    private String taxId;
    private String adress;
    private BigDecimal availableLimit;

}
