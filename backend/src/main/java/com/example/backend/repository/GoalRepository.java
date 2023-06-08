package com.example.backend.repository;

import com.example.backend.model.Goal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface GoalRepository extends CrudRepository<Goal, Integer> {

    @Query(
            value = "SELECT * FROM goal WHERE id_user=:id",
            nativeQuery = true)
    List<Goal> findAllGoalsById(@Param("id") Integer id);

    @Query(
            value = "SELECT * FROM goal WHERE id_goal=:id",
            nativeQuery = true)
    Goal findGoalById(@Param("id") Integer id);
}
