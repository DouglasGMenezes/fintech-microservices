package br.com.dgm.msavaliadorcredito.application.representation;

import java.math.BigDecimal;

public record CustomerCardDTO(
         String holderName,
         String cardBrand,
         BigDecimal approvedLimit
) {
}
