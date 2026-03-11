package at.technikum.springrestbackend.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SecurityConfigTest {

    @Test
    void security_config_instantiates() {

        SecurityConfig config = new SecurityConfig();

        assertNotNull(config);
    }
}