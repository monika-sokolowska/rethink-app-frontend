package com.example.backend.controller;

import com.example.backend.DTO.*;
import com.example.backend.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping(path="/transport/{id}")
    public ResponseEntity<List<TransportFootprintDTO>> getTransport(@PathVariable Integer id) {
        return ResponseEntity.ok(transportFootprintService.findTransportFootprintById(id));
    }

    @GetMapping(path="/food/{id}")
    public ResponseEntity<List<FoodFootprintDTO>> getFood(@PathVariable Integer id) {
        return ResponseEntity.ok(foodFootprintService.findFoodFootprintById(id));
    }

    @GetMapping(path="/other/{id}")
    public ResponseEntity<List<OtherFootprintDTO>> getOther(@PathVariable Integer id) {
        return ResponseEntity.ok(otherFootprintService.findOtherFootprintById(id));
    }

    @PostMapping(path="/add/transport/{id}")
    public ResponseEntity<TransportFootprintDTO> addTransport(@PathVariable Integer id, @RequestBody AddTransportDTO addTransportDTO) {

        dailyFootprintService.findOrCreateDailyFootprintById(id);

        return ResponseEntity.ok(transportFootprintService.addTransportFootprintById(id, addTransportDTO));
    }

    @PostMapping(path="/add/food/{id}")
    public ResponseEntity<FoodFootprintDTO> addFood(@PathVariable Integer id, @RequestBody AddFoodDTO addFoodDTO) {

        dailyFootprintService.findOrCreateDailyFootprintById(id);

        return ResponseEntity.ok(foodFootprintService.addFoodFootprintById(id, addFoodDTO));
    }

    @PostMapping(path="/add/other/{id}")
    public ResponseEntity<OtherFootprintDTO> addOther(@PathVariable Integer id, @RequestBody AddOtherDTO addOtherDTO) {

        dailyFootprintService.findOrCreateDailyFootprintById(id);

        return ResponseEntity.ok(otherFootprintService.addOtherFootprintById(id, addOtherDTO));
    }
}
