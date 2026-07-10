package br.com.dgm.msavaliadorcredito.infra.client.dto;

import lombok.Builder;

@Builder
public record CustomerResponseDTO(
        Long id,
        String taxId,
        String name,
        Integer age
) {
}
