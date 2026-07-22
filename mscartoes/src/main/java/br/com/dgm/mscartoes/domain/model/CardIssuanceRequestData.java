package br.com.dgm.mscartoes.domain.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CardIssuanceRequestData {

    private Long cardId;
    private String taxId;
    private String address;
    private BigDecimal availableLimit;

}