package br.com.dgm.mscartoes.domain.exception;

public class InvalidCardBrandException extends RuntimeException {
    public InvalidCardBrandException(String message) {
        super("Invalid card-brand holderName: " + message);
    }
}
