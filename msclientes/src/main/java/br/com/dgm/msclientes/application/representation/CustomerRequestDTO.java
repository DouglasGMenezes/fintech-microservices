package br.com.dgm.msclientes.application.representation;


public record CustomerRequestDTO(
    String taxId,
    String name,
    Integer age
) {}
