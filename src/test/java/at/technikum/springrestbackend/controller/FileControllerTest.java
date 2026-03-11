package at.technikum.springrestbackend.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileControllerTest {

    @Test
    void upload_returns_success() {

        FileController controller = new FileController();

        String result = controller.upload();

        assertEquals("file uploaded", result);
    }
}