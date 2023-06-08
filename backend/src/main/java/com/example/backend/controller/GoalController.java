package com.example.backend.controller;

import com.example.backend.DTO.*;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.backend.security.Utils.GetCurrentUser;

@RestController
@CrossOrigin
@RequestMapping(value = "goal")
public class GoalController {

    private GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping(path="/all")
    public ResponseEntity<List<GoalDTO>> goals() {
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(goalService.findAllGoalsById(user.getId()));

    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add")
    public ResponseEntity<GoalDTO> addGoal(@RequestBody AddGoalDTO addGoalDTO) {

        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(goalService.addGoalById(user.getId(), addGoalDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path="/delete")
    public ResponseEntity<GoalDTO> deleteGoal(@RequestBody DeleteDTO deleteDTO) {
        System.out.println("Delete");
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(goalService.deleteGoalById(user.getId(), deleteDTO.id()));
    }
}

