package at.technikum.springrestbackend.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {

    @Test
    void forbidden_exception_sets_message() {

        ForbiddenException ex =
            new ForbiddenException("forbidden");

        assertEquals("forbidden", ex.getMessage());
    }
}