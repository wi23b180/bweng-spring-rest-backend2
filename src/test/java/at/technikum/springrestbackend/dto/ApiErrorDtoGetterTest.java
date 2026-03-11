package at.technikum.springrestbackend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiErrorDtoGetterTest {

    @Test
    void getters_return_correct_values() {

        ApiErrorDto dto = new ApiErrorDto(
            500,
            "Internal Server Error",
            "something went wrong"
        );

        assertEquals(500, dto.getStatus());
        assertEquals("Internal Server Error", dto.getError());
        assertEquals("something went wrong", dto.getMessage());
    }
}