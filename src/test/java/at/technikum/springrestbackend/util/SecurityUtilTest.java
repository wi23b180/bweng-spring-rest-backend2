package at.technikum.springrestbackend.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SecurityUtilTest {

    @Test
    void util_class_instantiates() {

        SecurityUtil util = new SecurityUtil();

        assertNotNull(util);
    }
}