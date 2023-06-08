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

    private CompensatedFootprintService compensatedFootprintService;

    public DailyFootprintController(DailyFootprintService dailyFootprintService,
                                    TransportFootprintService transportFootprintService,
                                    FoodFootprintService foodFootprintService,
                                    OtherFootprintService otherFootprintService,
                                    CompensatedFootprintService compensatedFootprintService) {

        this.dailyFootprintService = dailyFootprintService;
        this.transportFootprintService = transportFootprintService;
        this.foodFootprintService = foodFootprintService;
        this.otherFootprintService = otherFootprintService;
        this.compensatedFootprintService = compensatedFootprintService;
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
    @GetMapping(path="/compensated")
    public ResponseEntity<List<CompensatedFootprintDTO>> getCompensated() {
        UserDetailsImpl user = GetCurrentUser();
        return ResponseEntity.ok(compensatedFootprintService.findCompensatedFootprintById(user.getId()));
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
    @PostMapping(path="/add/compensated")
    public ResponseEntity<CompensatedFootprintDTO> addCompensated(@RequestBody AddCompensatedDTO addCompensatedDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(compensatedFootprintService.addCompensatedFootprintById(user.getId(), addCompensatedDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path="/add/other")
    public ResponseEntity<OtherFootprintDTO> addOther(@RequestBody AddOtherDTO addOtherDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(otherFootprintService.addOtherFootprintById(user.getId(), addOtherDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path="/remove/food")
    public ResponseEntity<FoodFootprintDTO> removeFood(@RequestBody DeleteDTO deleteDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(foodFootprintService.removeFoodFootprintById(user.getId(), deleteDTO.id()));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path="/remove/compensated")
    public ResponseEntity<CompensatedFootprintDTO> removeCompensated(@RequestBody DeleteDTO deleteDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(compensatedFootprintService.removeCompensatedFootprintById(user.getId(), deleteDTO.id()));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path="/remove/other")
    public ResponseEntity<OtherFootprintDTO> removeOther(@RequestBody DeleteDTO deleteDTO ) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(otherFootprintService.removeOtherFootprintById(user.getId(), deleteDTO.id()));
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path="/remove/transport")
    public ResponseEntity<TransportFootprintDTO> removeTransport(@RequestBody DeleteDTO deleteDTO) {

        UserDetailsImpl user = GetCurrentUser();
        dailyFootprintService.findOrCreateDailyFootprintById(user.getId());

        return ResponseEntity.ok(transportFootprintService.removeTransportFootprintById(user.getId(), deleteDTO.id()));
    }
}
