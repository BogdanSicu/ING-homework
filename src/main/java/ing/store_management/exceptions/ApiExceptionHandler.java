package ing.store_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ApiNotFoundException exception) {

        ExceptionPayload exceptionPayload = new ExceptionPayload(
                exception.getMessage(),
                exception,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(exceptionPayload, exceptionPayload.httpStatus());
    }

}
