package com.example.backend.DTO;

import com.example.backend.util.Meal;

public record AddFoodDTO(
        String name,
        Meal meal,
        Float footprint
) {

}
