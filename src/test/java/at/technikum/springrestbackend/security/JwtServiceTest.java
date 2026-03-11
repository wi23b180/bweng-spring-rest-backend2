package at.technikum.springrestbackend.security;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtServiceTest {

    @Test
    void generate_token_returns_string() {
        JwtEncoder jwtEncoder = Mockito.mock(JwtEncoder.class);

        Jwt jwt = new Jwt(
            "test-token",
            Instant.now(),
            Instant.now().plusSeconds(3600),
            Map.of("alg", "HS256"),
            Map.of("sub", "user")
        );

        Mockito.when(jwtEncoder.encode(Mockito.any(JwtEncoderParameters.class)))
            .thenReturn(jwt);

        JwtService service = new JwtService(jwtEncoder, 3600L);

        String token = service.generateToken("user");

        assertNotNull(token);
        assertEquals("test-token", token);
    }
}