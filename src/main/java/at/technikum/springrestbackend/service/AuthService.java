package at.technikum.springrestbackend.service;

import at.technikum.springrestbackend.dto.LoginDto;
import at.technikum.springrestbackend.dto.RegisterDto;
import at.technikum.springrestbackend.entity.Role;
import at.technikum.springrestbackend.entity.User;
import at.technikum.springrestbackend.repository.UserRepository;
import at.technikum.springrestbackend.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("username already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        user.setCountry(dto.getCountry());
        user.setRole(Role.USER);
        user.setEnabled(true);
        user.setProfilePictureUrl(
            dto.getProfilePictureUrl() == null || dto.getProfilePictureUrl().isBlank()
                ? "https://placehold.co/200"
                : dto.getProfilePictureUrl()
        );

        userRepository.save(user);
    }

    public String login(LoginDto dto) {
        User user = userRepository.findByUsername(dto.getUsername())
            .orElseThrow(() -> new RuntimeException("invalid credentials"));

        boolean matches = passwordEncoder.matches(dto.getPassword(), user.getPasswordHash());
        if (!matches) {
            throw new RuntimeException("invalid credentials");
        }

        return jwtService.generateToken(user.getUsername());
    }
}