package com.example.backend.repository;

import com.example.backend.model.HouseholdFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HouseholdFootprintRepository extends CrudRepository<HouseholdFootprint, Integer> {

    @Query(
            value = "SELECT * FROM household_footprint WHERE id_user=:id",
            nativeQuery = true)
    HouseholdFootprint findHouseholdFootprintById(@Param("id") Integer id);
}