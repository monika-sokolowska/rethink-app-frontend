package com.example.backend.DTO;

import com.example.backend.util.Meal;

public record FoodFootprintDTO(
        Integer id,
        String name,
        Meal meal,
        Float footprint
) {

}
