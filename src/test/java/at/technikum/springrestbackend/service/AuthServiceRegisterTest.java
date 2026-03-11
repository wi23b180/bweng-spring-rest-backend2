package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.RegisterDto;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

class AuthServiceRegisterTest {

    @Test
    void register_creates_user() {

        UserRepository repo = Mockito.mock(UserRepository.class);
        PasswordEncoder encoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        AuthService service = new AuthService(repo, encoder, jwtService);

        RegisterDto dto = new RegisterDto();
        dto.setUsername("lama22");
        dto.setEmail("lama@test.com");
        dto.setPassword("Password123");
        dto.setCountry("AT");

        Mockito.when(repo.existsByUsername("lama22")).thenReturn(false);
        Mockito.when(encoder.encode("Password123")).thenReturn("encoded");

        service.register(dto);

        Mockito.verify(repo).save(Mockito.any(User.class));
    }
}