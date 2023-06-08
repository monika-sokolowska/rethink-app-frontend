package com.example.backend.repository;

import com.example.backend.model.DailyFootprint;
import com.example.backend.model.OtherFootprint;
import com.example.backend.model.TransportFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportFootprintRepository extends CrudRepository<TransportFootprint, Integer> {

    @Query(
            value = "SELECT * FROM transport_footprint WHERE id_daily_footprint = (SELECT id_daily_footprint FROM daily_footprint WHERE id_user=:id AND date=CURRENT_DATE)",
            nativeQuery = true)
    List<TransportFootprint> findTransportFootprintById(@Param("id") Integer id);

    @Query(
            value = "SELECT * FROM transport_footprint WHERE id_transport_footprint=:id",
            nativeQuery = true)
    TransportFootprint findOneTransportFootprintById(@Param("id") Integer id);

    @Query(
            value = "SELECT * FROM transport_footprint WHERE id_daily_footprint IN (SELECT id_daily_footprint FROM daily_footprint WHERE id_user=:id AND date between DATE_FORMAT(CURRENT_DATE, '%Y-%m-01') and CURRENT_DATE)",
            nativeQuery = true)
    List<TransportFootprint> findMonthlyTransportFootprintById(@Param("id") Integer id);
}