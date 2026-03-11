package at.technikum.springrestbackend.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegisterDtoTest {

    @Test
    void constructor_sets_fields() {

        RegisterDto dto = new RegisterDto();
        dto.setUsername("lama");
        dto.setPassword("password");
        dto.setEmail("lama@test.com");

        assertEquals("lama", dto.getUsername());
        assertEquals("password", dto.getPassword());
        assertEquals("lama@test.com", dto.getEmail());
    }
}