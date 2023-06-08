package com.example.backend.service;

import com.example.backend.DTO.AveragePersonDTO;
import com.example.backend.DTO.DailyFootprintDTO;
import com.example.backend.DTO.DailyStatsDTO;
import com.example.backend.model.*;
import com.example.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {
    private final TransportFootprintRepository transportFootprintRepository;
    private final OtherFootprintRepository otherFootprintRepository;
    private final FoodFootprintRepository foodFootprintRepository;
    private final DailyFootprintRepository dailyFootprintRepository;
    private final CompensatedFootprintRepository compensatedFootprintRepository;
    private final AveragePersonRepository averagePersonRepository;

    public StatsService(TransportFootprintRepository transportFootprintRepository, OtherFootprintRepository otherFootprintRepository, FoodFootprintRepository foodFootprintRepository, DailyFootprintRepository dailyFootprintRepository, CompensatedFootprintRepository compensatedFootprintRepository, AveragePersonRepository averagePersonRepository) {
        this.transportFootprintRepository = transportFootprintRepository;
        this.otherFootprintRepository = otherFootprintRepository;
        this.foodFootprintRepository = foodFootprintRepository;
        this.dailyFootprintRepository = dailyFootprintRepository;
        this.compensatedFootprintRepository = compensatedFootprintRepository;
        this.averagePersonRepository = averagePersonRepository;
    }

    public DailyStatsDTO getDailyStatsByID(Integer id) {
        Float sumDailyFootpintAverage = sumDailyFootprintById(id);
        AveragePerson averagePerson = averagePersonRepository.findAvergagePerson();

        return convertDailyStatsToDailyStatsDTO(averagePerson, sumDailyFootpintAverage);
    }

    public Float sumDailyFootprintById(Integer id)  {

        List<DailyFootprint> listOfEntities = dailyFootprintRepository.findMonthlyFootprintById(id);
        Float sum = (float) 0;

        for (DailyFootprint t : listOfEntities) {
            sum = sum+1;
        }


        Float transportFootprintSum = sumMonthlyTransportFootprintById(id);
        Float foodFootprintSum = sumMonthlyFoodFootprintById(id);
        Float otherFootprintSum = sumMonthlyOtherFootprintById(id);
        Float compensatedFootprintSum = sumMonthlyCompensatedFootprintById(id);

        System.out.println(transportFootprintSum);
        System.out.println(foodFootprintSum);
        System.out.println(otherFootprintSum);
        System.out.println(compensatedFootprintSum);
        System.out.println(sum);
        System.out.println((transportFootprintSum+foodFootprintSum+otherFootprintSum-compensatedFootprintSum)/sum);


        return (transportFootprintSum+foodFootprintSum+otherFootprintSum-compensatedFootprintSum)/sum;
    }


    public Float sumMonthlyTransportFootprintById(Integer id)  {

        List<TransportFootprint> listOfEntities = transportFootprintRepository.findMonthlyTransportFootprintById(id);
        Float sum = (float) 0;

        for (TransportFootprint t : listOfEntities) {
            sum += t.getFootprint();
        }
        return sum;
    }

    public Float sumMonthlyFoodFootprintById(Integer id)  {

        List<FoodFootprint> listOfEntities = foodFootprintRepository.findMonthlyFoodFootprintById(id);
        Float sum = (float) 0;

        for (FoodFootprint t : listOfEntities) {
            sum += t.getFootprint();
        }
        return sum;
    }

    public Float sumMonthlyOtherFootprintById(Integer id)  {

        List<OtherFootprint> listOfEntities = otherFootprintRepository.findMonthlyOtherFootprintById(id);
        Float sum = (float) 0;

        for (OtherFootprint t : listOfEntities) {
            sum += t.getFootprint();
        }
        return sum;
    }

    public Float sumMonthlyCompensatedFootprintById(Integer id)  {

        List<CompensatedFootprint> listOfEntities = compensatedFootprintRepository.findMonthlyCompensatedFootprintById(id);
        Float sum = (float) 0;

        for (CompensatedFootprint t : listOfEntities) {
            sum += t.getFootprint();
        }
        return sum;
    }

    public DailyStatsDTO convertDailyStatsToDailyStatsDTO(AveragePerson averagePerson, Float dailyFootprint) {
        return new DailyStatsDTO(
                averagePerson.getDailyFootprint(),
                dailyFootprint
        );
    }
}
