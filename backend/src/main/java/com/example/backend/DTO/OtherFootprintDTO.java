package com.example.backend.DTO;

import com.example.backend.util.Meal;

public record OtherFootprintDTO (
        Integer id,
        String name,
        Float footprint
) {

}