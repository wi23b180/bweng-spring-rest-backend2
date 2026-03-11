package at.technikum.springrestbackend.exception;

import at.technikum.springrestbackend.dto.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorDto> handleValidation(MethodArgumentNotValidException ex) {
        StringBuilder message = new StringBuilder("validation failed: ");

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            message.append(error.getField())
                .append(" -> ")
                .append(error.getDefaultMessage())
                .append("; ");
        }

        ApiErrorDto errorDto = new ApiErrorDto(
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            message.toString()
        );

        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorDto> handleIllegalArgument(IllegalArgumentException ex) {
        ApiErrorDto errorDto = new ApiErrorDto(
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            ex.getMessage()
        );

        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorDto> handleRuntime(RuntimeException ex) {
        ApiErrorDto errorDto = new ApiErrorDto(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrorDto> handleResponseStatus(ResponseStatusException ex) {

        ApiErrorDto error = new ApiErrorDto(
            ex.getStatusCode().value(),
            ex.getReason(),
            ex.getReason()
        );

        return ResponseEntity.status(ex.getStatusCode()).body(error);
    }
}