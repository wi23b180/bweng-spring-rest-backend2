package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.RegisterDto;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

class AuthServiceRegisterSuccessTest {

    @Test
    void register_success() {

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        PasswordEncoder encoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        AuthService service = new AuthService(userRepository, encoder, jwtService);

        RegisterDto dto = new RegisterDto();
        dto.setUsername("lama");
        dto.setPassword("123");
        dto.setEmail("lama@test.com");
        dto.setCountry("AT");

        Mockito.when(userRepository.existsByUsername("lama")).thenReturn(false);
        Mockito.when(encoder.encode("123")).thenReturn("encoded");

        service.register(dto);

        Mockito.verify(userRepository).save(Mockito.any());
    }
}