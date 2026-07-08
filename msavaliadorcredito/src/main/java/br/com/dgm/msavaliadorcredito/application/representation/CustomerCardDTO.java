package br.com.dgm.msavaliadorcredito.application.representation;

import br.com.dgm.msavaliadorcredito.domain.model.CustomerCard;
import br.com.dgm.msavaliadorcredito.domain.model.CustomerStatus;

import java.math.BigDecimal;

public record CustomerCardDTO(
         String holdernName,
         String cardBrand,
         BigDecimal approvedLimit
) {
}
