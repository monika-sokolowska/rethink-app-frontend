package com.example.backend.repository;

import com.example.backend.model.DailyFootprint;
import com.example.backend.model.FoodFootprint;
import com.example.backend.model.TransportFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DailyFootprintRepository extends CrudRepository<DailyFootprint, Integer> {

    @Query(
            value = "SELECT * FROM daily_footprint WHERE id_user=:id AND date=CURRENT_DATE",
            nativeQuery = true)
    DailyFootprint findDailyFootprintById(@Param("id") Integer id);
}
