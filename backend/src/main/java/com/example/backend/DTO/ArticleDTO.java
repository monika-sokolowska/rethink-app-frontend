package com.example.backend.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record ArticleDTO (
        Integer id,
        String title,
        String text,
        String image
) {

}
