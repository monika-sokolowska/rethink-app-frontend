package com.example.backend.repository;

import com.example.backend.model.AveragePerson;
import com.example.backend.model.CompensatedFootprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AveragePersonRepository extends CrudRepository<AveragePerson, Integer> {

    @Query(
            value = "SELECT * FROM average_person",
            nativeQuery = true)
    AveragePerson findAvergagePerson();

}
