package com.example.backend.DTO;

public record TransportFootprintDTO (
        Integer id,
        String name,
        Float kilometers,
        Float footprint
) {

}
