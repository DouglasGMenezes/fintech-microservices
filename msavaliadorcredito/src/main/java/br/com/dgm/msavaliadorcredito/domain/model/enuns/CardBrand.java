package br.com.dgm.msavaliadorcredito.domain.model.enuns;

import br.com.dgm.msavaliadorcredito.domain.exceptions.InvalidCardBrandException;

public enum CardBrand {
    MASTERCARD("mastercad"),
    VISA("visa"),
    ELO("elo"),
    HIPERCARD("hipercard"),
    BANRI_COMPRAS("banri compras"),
    AMEX("amex"),
    DINERS_CLUB("diners club");

    private final String label;

    CardBrand(String label) {
        this.label = label;
    }

    public static CardBrand from(String value) {
        String normalized = normalize(value);
        for (CardBrand brand : values()) {
            if (normalize(brand.name()).equals(normalized) || normalize(brand.label).equals(normalized)) {
                return brand;
            }
        }
        throw new InvalidCardBrandException(value);
    }

    private static String normalize(String value) {
        return value == null ? "" : value.trim().toUpperCase().replaceAll("[\\s_-]+", "");
    }
}
