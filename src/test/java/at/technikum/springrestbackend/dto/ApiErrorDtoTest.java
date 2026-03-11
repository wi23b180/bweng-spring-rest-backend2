package at.technikum.springrestbackend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiErrorDtoTest {

    @Test
    void constructor_sets_fields() {

        ApiErrorDto dto = new ApiErrorDto(
            400,
            "Bad Request",
            "validation failed"
        );

        assertEquals(400, dto.getStatus());
        assertEquals("Bad Request", dto.getError());
        assertEquals("validation failed", dto.getMessage());
    }
}