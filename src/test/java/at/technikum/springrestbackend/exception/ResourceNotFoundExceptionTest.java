package at.technikum.springrestbackend.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void resource_not_found_exception_sets_message() {

        ResourceNotFoundException ex =
            new ResourceNotFoundException("not found");

        assertEquals("not found", ex.getMessage());
    }
}