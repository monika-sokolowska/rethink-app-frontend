package com.example.backend.service;

import com.example.backend.DTO.DailyFootprintDTO;
import com.example.backend.model.DailyFootprint;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;


@Service
public class DailyFootprintService {
    private final DailyFootprintRepository dailyFootprintRepository;

    private final UserRepository userRepository;


    @Autowired
    public DailyFootprintService(DailyFootprintRepository dailyFootprintRepository, UserRepository userRepository) {
        this.dailyFootprintRepository = dailyFootprintRepository;
        this.userRepository = userRepository;
    }

    public DailyFootprint addDailyFootprintById(Integer id)  {

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        DailyFootprint footprint = new DailyFootprint();
        footprint.setDate(date);
        footprint.setUser(userRepository.findUserById(id));

        return dailyFootprintRepository.save(footprint);
    };

    public DailyFootprintDTO findOrCreateDailyFootprintById(Integer id)  {

        DailyFootprint footprint = dailyFootprintRepository.findDailyFootprintById(id);

        if (footprint == null) {
            footprint = addDailyFootprintById(id);
            return convertDailyFootprintToDailyFootprintDTO(footprint);
        } else {
            return convertDailyFootprintToDailyFootprintDTO(footprint);
        }
    }

    public DailyFootprintDTO convertDailyFootprintToDailyFootprintDTO(DailyFootprint footprint) {
        return new DailyFootprintDTO(
                footprint.getId(),
                footprint.getDate()
        );
    }

}
