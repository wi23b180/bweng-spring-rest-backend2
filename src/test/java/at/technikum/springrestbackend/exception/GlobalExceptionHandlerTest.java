package at.technikum.springrestbackend.exception;

import at.technikum.springrestbackend.dto.ApiErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @Test
    void handle_illegal_argument_returns_400() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        IllegalArgumentException ex = new IllegalArgumentException("bad input");

        ResponseEntity<ApiErrorDto> response = handler.handleIllegalArgument(ex);

        assertEquals(400, response.getStatusCode().value());
        assertEquals("Bad Request", response.getBody().getError());
        assertEquals("bad input", response.getBody().getMessage());
    }

    @Test
    void handle_runtime_returns_500() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        RuntimeException ex = new RuntimeException("boom");

        ResponseEntity<ApiErrorDto> response = handler.handleRuntime(ex);

        assertEquals(500, response.getStatusCode().value());
        assertEquals("Internal Server Error", response.getBody().getError());
        assertEquals("boom", response.getBody().getMessage());
    }

    @Test
    void handle_response_status_returns_given_status() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseStatusException ex =
            new ResponseStatusException(HttpStatus.FORBIDDEN, "forbidden");

        ResponseEntity<ApiErrorDto> response = handler.handleResponseStatus(ex);

        assertEquals(403, response.getStatusCode().value());
        assertEquals("forbidden", response.getBody().getError());
        assertEquals("forbidden", response.getBody().getMessage());
    }
}