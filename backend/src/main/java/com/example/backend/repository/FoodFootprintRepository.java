package com.example.backend.repository;

import com.example.backend.model.FoodFootprint;
import com.example.backend.model.OtherFootprint;
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

    @Query(
            value = "SELECT * FROM food_footprint WHERE id_food_footprint=:id",
            nativeQuery = true)
    FoodFootprint findOneFoodFootprintById(@Param("id") Integer id);

    @Query(
            value = "SELECT * FROM food_footprint WHERE id_daily_footprint IN (SELECT id_daily_footprint FROM daily_footprint WHERE id_user=:id AND date between DATE_FORMAT(CURRENT_DATE, '%Y-%m-01') and CURRENT_DATE)",
            nativeQuery = true)
    List<FoodFootprint> findMonthlyFoodFootprintById(@Param("id") Integer id);
}