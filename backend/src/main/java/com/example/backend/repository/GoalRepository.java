package com.example.backend.repository;

import com.example.backend.DTO.GoalDTO;
import com.example.backend.model.Goal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;


public interface GoalRepository extends CrudRepository<Goal, Integer> {

    @Query(
            value = "SELECT * FROM goal WHERE id_user=:id",
            nativeQuery = true)
    List<Goal> findAllGoalsById(@Param("id") Integer id);
}
