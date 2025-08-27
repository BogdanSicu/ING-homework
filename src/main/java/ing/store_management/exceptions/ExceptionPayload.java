package ing.store_management.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ExceptionPayload(
        String message,
        HttpStatus httpStatus,
        ZonedDateTime timestamp) {
}
