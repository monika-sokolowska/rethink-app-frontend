package com.example.backend.service;

import com.example.backend.DTO.AddFoodDTO;
import com.example.backend.DTO.AddOtherDTO;
import com.example.backend.DTO.FoodFootprintDTO;
import com.example.backend.DTO.OtherFootprintDTO;
import com.example.backend.model.FoodFootprint;
import com.example.backend.model.OtherFootprint;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.OtherFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
