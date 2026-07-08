package br.com.dgm.msclientes.application.representation;

import lombok.Builder;


@Builder
public record CustomerResponseDTO(
        Long id,
        String taxId,
        String name,
        Integer age
) {
}
