package at.technikum.springrestbackend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginDtoTest {

    @Test
    void getters_and_setters_work() {
        LoginDto dto = new LoginDto();
        dto.setUsername("lama");
        dto.setPassword("Password123");

        assertEquals("lama", dto.getUsername());
        assertEquals("Password123", dto.getPassword());
    }
}