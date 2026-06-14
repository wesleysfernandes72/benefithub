package com.wesleysfernandes.benefithub.auth.controller;

import com.wesleysfernandes.benefithub.auth.dto.LoginRequest;
import com.wesleysfernandes.benefithub.auth.dto.LoginResponse;
import com.wesleysfernandes.benefithub.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
            ) {
        authService.login(request);

        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}
