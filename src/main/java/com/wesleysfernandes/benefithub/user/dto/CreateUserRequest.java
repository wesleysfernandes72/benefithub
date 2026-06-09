package com.wesleysfernandes.benefithub.user.dto;

import com.wesleysfernandes.benefithub.user.entity.Role;

public record CreateUserRequest(
        String username,
        String password,
        Role role
) {
}
