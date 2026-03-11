package at.technikum.springrestbackend.exception;

import at.technikum.springrestbackend.dto.ApiErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerResponseStatusTest {

    @Test
    void handle_response_status_returns_correct_values() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseStatusException ex =
            new ResponseStatusException(HttpStatus.FORBIDDEN, "forbidden");

        ResponseEntity<ApiErrorDto> response = handler.handleResponseStatus(ex);

        assertEquals(403, response.getStatusCode().value());
        assertEquals(403, response.getBody().getStatus());
        assertEquals("forbidden", response.getBody().getError());
        assertEquals("forbidden", response.getBody().getMessage());
    }
}