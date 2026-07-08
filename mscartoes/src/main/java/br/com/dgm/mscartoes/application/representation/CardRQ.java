package br.com.dgm.mscartoes.application.representation;

import java.math.BigDecimal;

public record CardRQ(
        String holderName,
        String cardBrand,
        BigDecimal creditLimit,
        BigDecimal income
) {
}
