package br.com.dgm.msavaliadorcredito.infra.client.dto;

import java.math.BigDecimal;

public record CardCustomerRS(
    String holderName,
    String cardBrand,
    BigDecimal approvedLimit) {
}
