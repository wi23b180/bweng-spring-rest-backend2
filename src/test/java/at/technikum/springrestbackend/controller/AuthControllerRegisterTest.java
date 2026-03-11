package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.RegisterDto;
import at.technikum.springrestbackend.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerRegisterTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AuthService authService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void register_endpoint_returns_201() throws Exception {
        RegisterDto dto = new RegisterDto();
        dto.setUsername("lama22");
        dto.setEmail("lama22@test.com");
        dto.setPassword("Password123");
        dto.setCountry("AT");
        dto.setProfilePictureUrl("https://placehold.co/200");

        mockMvc.perform(post("/auth/register")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isCreated());

        Mockito.verify(authService).register(Mockito.any(RegisterDto.class));
    }
}