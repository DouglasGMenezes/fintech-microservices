package br.com.dgm.msavaliadorcredito.domain.exceptions;

public class InvalidCardBrandException extends RuntimeException {
    public InvalidCardBrandException(String message) {
        super("Invalid card-brand holderName: " + message);
    }
}
