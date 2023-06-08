package com.example.backend.service;

import com.example.backend.DTO.*;
import com.example.backend.model.FoodFootprint;
import com.example.backend.model.Goal;
import com.example.backend.model.OtherFootprint;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.OtherFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OtherFootprintService {
    private final OtherFootprintRepository otherFootprintRepository;
    private final DailyFootprintRepository dailyFootprintRepository;


    @Autowired
    public OtherFootprintService(OtherFootprintRepository otherFootprintRepository, DailyFootprintRepository dailyFootprintRepository) {
        this.otherFootprintRepository = otherFootprintRepository;
        this.dailyFootprintRepository = dailyFootprintRepository;
    }

    public List<OtherFootprintDTO> findOtherFootprintById(Integer id)  {

        List<OtherFootprint> listOfEntities = otherFootprintRepository.findOtherFootprintById(id);
        ArrayList<OtherFootprintDTO> listOfDTOs = new ArrayList<OtherFootprintDTO>();

        for (OtherFootprint o : listOfEntities) {
            listOfDTOs.add(convertOtherFootprintToOtherFootprintDTO(o));
            System.out.println(listOfDTOs);
        }
        return listOfDTOs;
    }

    public OtherFootprintDTO removeOtherFootprintById(Integer id, Integer goalId)  {

        OtherFootprint otherFootprint = otherFootprintRepository.findOneOtherFootprintById(goalId);


        if (otherFootprint == null) {
            return null;
        }
        if(Objects.equals(otherFootprint.getDailyFootprint().getUser().getId(), id)) {
            otherFootprintRepository.deleteById(goalId);
        }

        return convertOtherFootprintToOtherFootprintDTO(otherFootprint);
    }

    public OtherFootprintDTO addOtherFootprintById(Integer id, AddOtherDTO addOtherDTO)  {
       OtherFootprint otherFootprint = new OtherFootprint();
        otherFootprint.setFootprint(addOtherDTO.footprint());
        otherFootprint.setName(addOtherDTO.name());
        otherFootprint.setDailyFootprint(dailyFootprintRepository.findDailyFootprintById(id));

       otherFootprintRepository.save(otherFootprint);

        return convertOtherFootprintToOtherFootprintDTO(otherFootprint);
    }

    public OtherFootprintDTO convertOtherFootprintToOtherFootprintDTO(OtherFootprint footprint) {
        return new OtherFootprintDTO(
                footprint.getId(),
                footprint.getName(),
                footprint.getFootprint()
        );
    }
}
