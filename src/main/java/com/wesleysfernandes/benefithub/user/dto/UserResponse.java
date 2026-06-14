package com.wesleysfernandes.benefithub.user.dto;

import com.wesleysfernandes.benefithub.user.entity.Role;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String username,
        Role role
) {
}
