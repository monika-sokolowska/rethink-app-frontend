package com.example.backend.service;

import com.example.backend.DTO.AddFoodDTO;
import com.example.backend.DTO.CompensatedFootprintDTO;
import com.example.backend.DTO.FoodFootprintDTO;
import com.example.backend.model.CompensatedFootprint;
import com.example.backend.model.FoodFootprint;
import com.example.backend.repository.DailyFootprintRepository;
import com.example.backend.repository.FoodFootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FoodFootprintService    {
    private final FoodFootprintRepository foodFootprintRepository;
    private final DailyFootprintRepository dailyFootprintRepository;


        @Autowired
        public FoodFootprintService(FoodFootprintRepository foodFootprintRepository, DailyFootprintRepository dailyFootprintRepository) {
            this.foodFootprintRepository = foodFootprintRepository;
            this.dailyFootprintRepository = dailyFootprintRepository;
        }

        public List<FoodFootprintDTO> findFoodFootprintById(Integer id)  {

            List<FoodFootprint> listOfEntities = foodFootprintRepository.findFoodFootprintById(id);
            ArrayList<FoodFootprintDTO> listOfDTOs = new ArrayList<FoodFootprintDTO>();

            for (FoodFootprint f : listOfEntities) {
                listOfDTOs.add(convertFoodFootprintToFoodFootprintDTO(f));
                System.out.println(listOfDTOs);
            }
            return listOfDTOs;
        }

    public FoodFootprintDTO addFoodFootprintById(Integer id, AddFoodDTO addFoodDTO)  {
        FoodFootprint foodFootprint = new FoodFootprint();
        foodFootprint.setFootprint(addFoodDTO.footprint());
        foodFootprint.setMeal(addFoodDTO.meal());
        foodFootprint.setName(addFoodDTO.name());
        foodFootprint.setDailyFootprint(dailyFootprintRepository.findDailyFootprintById(id));

        foodFootprintRepository.save(foodFootprint);

        return convertFoodFootprintToFoodFootprintDTO(foodFootprint);
    }

    public FoodFootprintDTO removeFoodFootprintById(Integer id, Integer goalId)  {

        FoodFootprint foodFootprint = foodFootprintRepository.findOneFoodFootprintById(goalId);


        if (foodFootprint == null) {
            return null;
        }
        if(Objects.equals(foodFootprint.getDailyFootprint().getUser().getId(), id)) {
            foodFootprintRepository.deleteById(goalId);
        }

        return convertFoodFootprintToFoodFootprintDTO(foodFootprint);
    }

        public FoodFootprintDTO convertFoodFootprintToFoodFootprintDTO(FoodFootprint footprint) {
            return new FoodFootprintDTO(
                    footprint.getId(),
                    footprint.getName(),
                    footprint.getMeal(),
                    footprint.getFootprint()
            );
        }
}
