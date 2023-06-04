package com.example.backend.controller;

import com.example.backend.DTO.*;
import com.example.backend.security.services.UserDetailsImpl;
import com.example.backend.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.backend.security.Utils.GetCurrentUser;

@RestController
@CrossOrigin
@RequestMapping(value = "footprint")
public class DailyFootprintController {

    private DailyFootprintService dailyFootprintService;
    private TransportFootprintService transportFootprintService;

    private FoodFootprintService foodFootprintService;

    private OtherFootprintService otherFootprintService;

    public DailyFootprintController(DailyFootprintService dailyFootprintService,
                                    TransportFootprintService transportFootprintService,
                                    FoodFootprintService foodFootprintService,
                                    OtherFootprintService otherFootprintService) {

        this.dailyFootprintService = dailyFootprintService;
        this.transportFootprintService = transportFootprintService;
        this.foodFootprintService = foodFootprintService;
        this.otherFootprintService = otherFootprintService;
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping(path="/transport")
    public ResponseEntity<List<TransportFootprintDTO>> getTransport() {
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(transportFootprintService.findTransportFootprintById(user.getId()));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path="/food")
    public ResponseEntity<List<FoodFootprintDTO>> getFood() {
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(foodFootprintService.findFoodFootprintById(user.getId()));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(path="/other")
    public ResponseEntity<List<OtherFootprintDTO>> getOther() {
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(otherFootprintService.findOtherFootprintById(user.getId()));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add/transport")
    public ResponseEntity<TransportFootprintDTO> addTransport(@RequestBody AddTransportDTO addTransportDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(transportFootprintService.addTransportFootprintById(user.getId(), addTransportDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add/food")
    public ResponseEntity<FoodFootprintDTO> addFood(@RequestBody AddFoodDTO addFoodDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(foodFootprintService.addFoodFootprintById(user.getId(), addFoodDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add/other")
    public ResponseEntity<OtherFootprintDTO> addOther(@RequestBody AddOtherDTO addOtherDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(otherFootprintService.addOtherFootprintById(user.getId(), addOtherDTO));
    }
}
