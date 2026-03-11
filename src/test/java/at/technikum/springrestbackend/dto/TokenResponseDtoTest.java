package at.technikum.springrestbackend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenResponseDtoTest {

    @Test
    void constructor_and_getter_work() {
        TokenResponseDto dto = new TokenResponseDto("abc-token");
        assertEquals("abc-token", dto.getToken());
    }
}