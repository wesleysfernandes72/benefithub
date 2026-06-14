package com.wesleysfernandes.benefithub.user.service;

import com.wesleysfernandes.benefithub.user.dto.CreateUserRequest;
import com.wesleysfernandes.benefithub.user.entity.User;
import com.wesleysfernandes.benefithub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public User create (CreateUserRequest request) {

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();

        return repository.save(user);
    }
}
