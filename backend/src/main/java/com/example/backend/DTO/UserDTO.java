package com.example.backend.DTO;

public record UserDTO(
        Integer id,
        String name,
        String lastName,
        String email,
        String password,
        Float mainGoal
) {


}