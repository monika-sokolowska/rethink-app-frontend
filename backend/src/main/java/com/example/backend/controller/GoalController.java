package com.example.backend.controller;

import com.example.backend.DTO.AddGoalDTO;
import com.example.backend.DTO.AddOtherDTO;
import com.example.backend.DTO.GoalDTO;
import com.example.backend.DTO.OtherFootprintDTO;
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
    public ResponseEntity<GoalDTO> addOther(@RequestBody AddGoalDTO addGoalDTO) {

        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(goalService.addGoalById(user.getId(), addGoalDTO));
    }
}

