package com.wesleysfernandes.benefithub.user.controller;


import com.wesleysfernandes.benefithub.user.dto.CreateUserRequest;
import com.wesleysfernandes.benefithub.user.entity.User;
import com.wesleysfernandes.benefithub.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User create(
            @RequestBody CreateUserRequest request
            ) {
        return service.create(request);
    }
}
