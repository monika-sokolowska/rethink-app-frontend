package com.example.backend.service;

import com.example.backend.DTO.*;
import com.example.backend.model.Goal;
import com.example.backend.repository.GoalRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    public List<GoalDTO> findAllGoalsById(Integer id)  {

        List<Goal> listOfEntities = goalRepository.findAllGoalsById(id);
        ArrayList<GoalDTO> listOfDTOs = new ArrayList<GoalDTO>();

        for (Goal g : listOfEntities) {
            listOfDTOs.add(convertGoalToGoalDTO(g));
            System.out.println(listOfDTOs);
        }
        return listOfDTOs;
    }

    public GoalDTO addGoalById(Integer id, AddGoalDTO addGoalDTO)  {
        Goal goal = new Goal();
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        goal.setDescription(addGoalDTO.name());
        goal.setDate(date);
        goal.setUser(userRepository.findUserById(id));

        goalRepository.save(goal);

        return convertGoalToGoalDTO(goal);
    }

    public GoalDTO convertGoalToGoalDTO(Goal goal) {
        return new GoalDTO(
                goal.getId(),
                goal.getDate(),
                goal.getDescription(),
                goal.getUser().getId()
        );
    }
}
