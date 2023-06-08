package com.example.backend.DTO;

import jakarta.persistence.Column;

public record AveragePersonDTO(Integer id, String country, Float dailyFootprint, Float householdFootprint) {

}
