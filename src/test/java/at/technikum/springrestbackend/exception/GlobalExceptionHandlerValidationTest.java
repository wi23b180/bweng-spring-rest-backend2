package at.technikum.springrestbackend.exception;

import at.technikum.springrestbackend.dto.ApiErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GlobalExceptionHandlerValidationTest {

    @Test
    void handle_validation_returns_400_and_message() throws Exception {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        BeanPropertyBindingResult bindingResult =
            new BeanPropertyBindingResult(new Object(), "registerDto");
        bindingResult.addError(
            new FieldError("registerDto", "username", "must not be blank")
        );

        MethodParameter parameter = new MethodParameter(
            DummyController.class.getDeclaredMethod("dummyMethod", String.class), 0
        );

        MethodArgumentNotValidException ex =
            new MethodArgumentNotValidException(parameter, bindingResult);

        ResponseEntity<ApiErrorDto> response = handler.handleValidation(ex);

        assertEquals(400, response.getStatusCode().value());
        assertEquals(400, response.getBody().getStatus());
        assertEquals("Bad Request", response.getBody().getError());
        assertTrue(response.getBody().getMessage().contains("username"));
    }

    static class DummyController {
        public void dummyMethod(String value) {
        }
    }
}