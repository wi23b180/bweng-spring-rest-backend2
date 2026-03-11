package at.technikum.springrestbackend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @PostMapping("/upload")
    public String upload() {
        return "file uploaded";
    }
}