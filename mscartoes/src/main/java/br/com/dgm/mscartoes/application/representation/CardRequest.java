package br.com.dgm.mscartoes.application.representation;

import java.math.BigDecimal;

public record CardRequest(
        String holderName,
        String cardBrand,
        BigDecimal creditLimit,
        BigDecimal income
) {
}
