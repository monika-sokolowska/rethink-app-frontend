package com.example.backend.DTO;

import com.example.backend.model.ERole;

import java.util.Set;

public record UserDTO(
        Integer id,
        String name,
        String lastName,
        String email,
        String password,
        Float mainGoal,
        Set<ERole> roles
) {


}