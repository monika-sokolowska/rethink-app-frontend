package com.example.backend.controller;

import com.example.backend.DTO.AddGoalDTO;
import com.example.backend.DTO.AddOtherDTO;
import com.example.backend.DTO.GoalDTO;
import com.example.backend.DTO.OtherFootprintDTO;
import com.example.backend.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "goal")
public class GoalController {

    private GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }


    @GetMapping(path="/all/{id}")
    public ResponseEntity<List<GoalDTO>> goals(@PathVariable Integer id) {

            return ResponseEntity.ok(goalService.findAllGoalsById(id));

    }

    @PostMapping(path="/add/{id}")
    public ResponseEntity<GoalDTO> addOther(@PathVariable Integer id, @RequestBody AddGoalDTO addGoalDTO) {

        return ResponseEntity.ok(goalService.addGoalById(id, addGoalDTO));
    }
}
