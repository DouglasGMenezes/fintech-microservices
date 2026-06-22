package br.com.dgm.mscartoes.application.exception;

import java.time.OffsetDateTime;

public record ApiErrorResponse(
        OffsetDateTime timestamp,
        int status,
        String error,
        String message
) {
}
