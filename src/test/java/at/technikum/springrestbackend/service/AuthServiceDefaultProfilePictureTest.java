package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AuthServiceDefaultProfilePictureTest {

    @Test
    void service_instantiates() {

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
        JwtService jwtService = Mockito.mock(JwtService.class);

        AuthService service =
            new AuthService(userRepository, passwordEncoder, jwtService);

        assertNotNull(service);
    }
}