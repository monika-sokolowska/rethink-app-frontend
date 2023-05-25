package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}