package com.example.backend.DTO;

import com.example.backend.model.User;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

public record GoalDTO (Integer id, Date date, String description, Integer userID ) {
}
