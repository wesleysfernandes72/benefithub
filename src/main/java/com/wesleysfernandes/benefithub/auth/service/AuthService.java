package com.wesleysfernandes.benefithub.auth.service;

import com.wesleysfernandes.benefithub.auth.dto.LoginRequest;
import com.wesleysfernandes.benefithub.auth.dto.LoginResponse;
import com.wesleysfernandes.benefithub.auth.security.JwtService;
import com.wesleysfernandes.benefithub.user.entity.User;
import com.wesleysfernandes.benefithub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.username())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.password(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user);

        return new LoginResponse(token);
    }
}