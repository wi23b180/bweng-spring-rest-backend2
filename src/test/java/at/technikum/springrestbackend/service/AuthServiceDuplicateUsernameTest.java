package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthServiceDuplicateUsernameTest {

    @Test
    void duplicate_username_throws_exception() {

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        AuthService service =
            new AuthService(userRepository, passwordEncoder, jwtService);

        Mockito.when(userRepository.existsByUsername("lama"))
            .thenReturn(true);

        assertThrows(RuntimeException.class,
            () -> service.register(null));
    }
}