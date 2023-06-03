package com.example.backend.repository;

import com.example.backend.model.FoodFootprint;
import com.example.backend.model.OtherFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtherFootprintRepository extends CrudRepository<OtherFootprint, Integer> {

    @Query(
            value = "SELECT * FROM other_footprint WHERE id_daily_footprint = (SELECT id_daily_footprint FROM daily_footprint WHERE id_user=:id AND date=CURRENT_DATE)",
            nativeQuery = true)
    List<OtherFootprint> findOtherFootprintById(@Param("id") Integer id);
}