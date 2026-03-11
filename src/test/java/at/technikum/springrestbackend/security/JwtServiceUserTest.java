package at.technikum.springrestbackend.security;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Instant;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtServiceUserTest {

    @Test
    void generate_token_for_user() {

        JwtEncoder encoder = Mockito.mock(JwtEncoder.class);

        Jwt jwt = new Jwt(
            "token.value",
            Instant.now(),
            Instant.now().plusSeconds(3600),
            Map.of("alg","HS256"),
            Map.of("sub","test")
        );

        Mockito.when(encoder.encode(Mockito.any(JwtEncoderParameters.class)))
            .thenReturn(jwt);

        JwtService service =
            new JwtService(encoder,3600);

        String token = service.generateToken("test");

        assertNotNull(token);
    }
}