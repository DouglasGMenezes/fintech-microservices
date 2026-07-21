package br.com.dgm.msavaliadorcredito.application.exceptions;

public class ErrorCardRequestException extends RuntimeException {
    public ErrorCardRequestException(String message) {
        super(message);
    }
}
