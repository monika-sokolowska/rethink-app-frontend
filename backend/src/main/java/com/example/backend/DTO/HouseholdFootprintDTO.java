package com.example.backend.DTO;

import jakarta.persistence.Column;

import java.sql.Date;

public record HouseholdFootprintDTO(Integer id, Date date, Float footprint) {


}
