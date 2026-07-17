package br.com.dgm.msavaliadorcredito.application.exceptions;


public class ErrorConnectionMicroserviceException extends RuntimeException {

    public ErrorConnectionMicroserviceException(String message, Throwable cause) {
        super(message, cause);
    }
}
