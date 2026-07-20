package br.com.dgm.msavaliadorcredito.domain.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class EvaluationData {

    private String taxId;
    private BigDecimal income;

}
