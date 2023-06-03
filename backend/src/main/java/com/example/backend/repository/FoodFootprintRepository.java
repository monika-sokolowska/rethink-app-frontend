package com.example.backend.repository;

import com.example.backend.model.FoodFootprint;
import com.example.backend.model.TransportFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodFootprintRepository extends CrudRepository<FoodFootprint, Integer> {

    @Query(
            value = "SELECT * FROM food_footprint WHERE id_daily_footprint = (SELECT id_daily_footprint FROM daily_footprint WHERE id_user=:id AND date=CURRENT_DATE)",
            nativeQuery = true)
    List<FoodFootprint> findFoodFootprintById(@Param("id") Integer id);
}