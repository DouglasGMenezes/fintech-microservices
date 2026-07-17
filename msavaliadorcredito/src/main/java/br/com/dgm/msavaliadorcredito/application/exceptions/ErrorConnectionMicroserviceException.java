package br.com.dgm.msavaliadorcredito.application.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorConnectionMicroserviceException extends RuntimeException {

    public ErrorConnectionMicroserviceException(String message, Throwable cause) {
        super(message, cause);
    }
}
