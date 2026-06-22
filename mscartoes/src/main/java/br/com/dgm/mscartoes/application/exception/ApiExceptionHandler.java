package br.com.dgm.mscartoes.application.exception;

import br.com.dgm.mscartoes.domain.exception.InvalidCardBrandException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(InvalidCardBrandException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCardBrand(InvalidCardBrandException ex) {
        return ResponseEntity.badRequest().body(new ApiErrorResponse(
                OffsetDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage()
        ));
    }

}
