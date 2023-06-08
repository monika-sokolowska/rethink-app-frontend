package com.example.backend.service;

import com.example.backend.DTO.*;
import com.example.backend.model.CompensatedFootprint;
import com.example.backend.model.OtherFootprint;
import com.example.backend.model.TransportFootprint;
import com.example.backend.repository.CompensatedFootprintRepository;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.OtherFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CompensatedFootprintService {
    private final CompensatedFootprintRepository compensatedFootprintRepository;
    private final DailyFootprintRepository dailyFootprintRepository;


    @Autowired
    public CompensatedFootprintService(CompensatedFootprintRepository compensatedFootprintRepository, DailyFootprintRepository dailyFootprintRepository) {
        this.compensatedFootprintRepository = compensatedFootprintRepository;
        this.dailyFootprintRepository = dailyFootprintRepository;
    }

    public List<CompensatedFootprintDTO> findCompensatedFootprintById(Integer id)  {

        List<CompensatedFootprint> listOfEntities = compensatedFootprintRepository.findCompensatedFootprintById(id);
        ArrayList<CompensatedFootprintDTO> listOfDTOs = new ArrayList<CompensatedFootprintDTO>();

        for (CompensatedFootprint c : listOfEntities) {
            listOfDTOs.add(convertCompensatedFootprintToCompensatedFootprintDTO(c));
            System.out.println(listOfDTOs);
        }
        return listOfDTOs;
    }

    public CompensatedFootprintDTO addCompensatedFootprintById(Integer id, AddCompensatedDTO addCompensatedDTO)  {
        CompensatedFootprint compensatedFootprint = new CompensatedFootprint();
        compensatedFootprint.setFootprint(addCompensatedDTO.footprint());
        compensatedFootprint.setName(addCompensatedDTO.name());
        compensatedFootprint.setDailyFootprint(dailyFootprintRepository.findDailyFootprintById(id));

        compensatedFootprintRepository.save(compensatedFootprint);

        return convertCompensatedFootprintToCompensatedFootprintDTO(compensatedFootprint);
    }
    public CompensatedFootprintDTO removeCompensatedFootprintById(Integer id, Integer goalId)  {

        CompensatedFootprint compensatedFootprint = compensatedFootprintRepository.findOneCompensatedFootprintById(goalId);


        if (compensatedFootprint == null) {
            return null;
        }
        if(Objects.equals(compensatedFootprint.getDailyFootprint().getUser().getId(), id)) {
            compensatedFootprintRepository.deleteById(goalId);
        }

        return convertCompensatedFootprintToCompensatedFootprintDTO(compensatedFootprint);
    }


    public CompensatedFootprintDTO convertCompensatedFootprintToCompensatedFootprintDTO(CompensatedFootprint footprint) {
        return new CompensatedFootprintDTO(
                footprint.getId(),
                footprint.getName(),
                footprint.getFootprint()
        );
    }
}