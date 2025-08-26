package ing.store_management.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ExceptionPayload(
        String message,
        Throwable throwable,
        HttpStatus httpStatus,
        ZonedDateTime timestamp) {
}
