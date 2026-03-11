package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.LoginDto;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceLoginTest {

    @Test
    void login_success() {

        UserRepository repo = Mockito.mock(UserRepository.class);
        PasswordEncoder encoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        AuthService service = new AuthService(repo, encoder, jwtService);

        LoginDto dto = new LoginDto();
        dto.setUsername("lama");
        dto.setPassword("Password123");

        User user = new User();
        user.setUsername("lama");
        user.setPasswordHash("encoded");

        Mockito.when(repo.findByUsername("lama")).thenReturn(Optional.of(user));
        Mockito.when(encoder.matches("Password123", "encoded")).thenReturn(true);
        Mockito.when(jwtService.generateToken("lama")).thenReturn("token123");

        String token = service.login(dto);

        assertEquals("token123", token);
    }
}