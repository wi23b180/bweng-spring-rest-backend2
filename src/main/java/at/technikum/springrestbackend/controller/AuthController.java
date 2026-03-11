package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.LoginDto;
import at.technikum.springrestbackend.dto.RegisterDto;
import at.technikum.springrestbackend.dto.TokenResponseDto;
import at.technikum.springrestbackend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterDto dto) {
        authService.register(dto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@Valid @RequestBody LoginDto dto) {
        String token = authService.login(dto);
        return new TokenResponseDto(token);
    }
}