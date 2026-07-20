package br.com.dgm.msavaliadorcredito.application.representation;

import java.math.BigDecimal;

public record EvaluationDataDTO(
     String taxId,
     BigDecimal income
) {
}
