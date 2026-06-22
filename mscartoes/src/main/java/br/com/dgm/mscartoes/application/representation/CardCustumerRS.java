package br.com.dgm.mscartoes.application.representation;

import java.math.BigDecimal;


public record CardCustumerRS(
        String holderName,
        String cardBrand,
        BigDecimal approvedLimit
) {
}
