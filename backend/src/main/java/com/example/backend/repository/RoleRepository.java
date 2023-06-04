package com.example.backend.repository;

import com.example.backend.model.ERole;
import com.example.backend.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(ERole name);
}