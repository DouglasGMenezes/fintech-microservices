package br.com.dgm.mscartoes.application.representation;

import java.math.BigDecimal;

public record CardRS(
        Long id,
        String holderName,
        String cardBrand,
        BigDecimal creditLimit,
        BigDecimal income
) {
}
