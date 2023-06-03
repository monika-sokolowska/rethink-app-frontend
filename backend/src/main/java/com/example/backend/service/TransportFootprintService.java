package com.example.backend.service;

import com.example.backend.DTO.AddTransportDTO;
import com.example.backend.DTO.TransportFootprintDTO;
import com.example.backend.model.DailyFootprint;
import com.example.backend.model.TransportFootprint;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.TransportFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
public class TransportFootprintService {

    private final TransportFootprintRepository transportFootprintRepository;
    private final DailyFootprintRepository dailyFootprintRepository;


    @Autowired
    public TransportFootprintService(TransportFootprintRepository transportFootprintRepository, DailyFootprintRepository dailyFootprintRepository) {
        this.transportFootprintRepository = transportFootprintRepository;
        this.dailyFootprintRepository = dailyFootprintRepository;
    }

    public List<TransportFootprintDTO> findTransportFootprintById(Integer id)  {

        List<TransportFootprint> listOfEntities = transportFootprintRepository.findTransportFootprintById(id);
        ArrayList<TransportFootprintDTO> listOfDTOs = new ArrayList<TransportFootprintDTO>();

        for (TransportFootprint t : listOfEntities) {
            listOfDTOs.add(convertTransportFootprintToTransportFootprintDTO(t));
            System.out.println(listOfDTOs);
        }
        return listOfDTOs;
    }

    public TransportFootprintDTO addTransportFootprintById(Integer id, AddTransportDTO addTransportDTO)  {
        TransportFootprint transportFootprint = new TransportFootprint();
        transportFootprint.setFootprint(addTransportDTO.footprint());
        transportFootprint.setKilometers(addTransportDTO.kilometers());
        transportFootprint.setName(addTransportDTO.name());
        transportFootprint.setDailyFootprint(dailyFootprintRepository.findDailyFootprintById(id));

        transportFootprintRepository.save(transportFootprint);

        return convertTransportFootprintToTransportFootprintDTO(transportFootprint);
    }


    public TransportFootprintDTO convertTransportFootprintToTransportFootprintDTO(TransportFootprint footprint) {
        return new TransportFootprintDTO(
                footprint.getId(),
                footprint.getName(),
                footprint.getKilometers(),
                footprint.getFootprint()
        );
    }
}
