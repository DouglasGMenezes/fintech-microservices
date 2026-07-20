package br.com.dgm.msavaliadorcredito.infra.client.dto;

import java.math.BigDecimal;

public record CardRS(
        Long id,
        String holderName,
        String cardBrand,
        BigDecimal creditLimit,
        BigDecimal income
) {
}
