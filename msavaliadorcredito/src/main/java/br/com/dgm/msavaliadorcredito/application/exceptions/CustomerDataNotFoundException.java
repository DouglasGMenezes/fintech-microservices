package br.com.dgm.msavaliadorcredito.application.exceptions;

public class CustomerDataNotFoundException extends RuntimeException {
    public CustomerDataNotFoundException(String taxId) {
        super("Dados do cliente não encontrado para o CPF/CNPJ informado: " + taxId);
    }
}
