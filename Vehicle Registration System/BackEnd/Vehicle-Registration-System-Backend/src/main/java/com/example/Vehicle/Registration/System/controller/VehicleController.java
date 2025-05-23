package com.example.Vehicle.Registration.System.controller;

import com.example.Vehicle.Registration.System.model.Vehicle;
import com.example.Vehicle.Registration.System.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    // Search vehicle details
    @PostMapping("/search")
    public List<Vehicle> searchVehicles(@RequestParam("registrationNumber") String vehicleNo) {
        return vehicleService.findByRegistrationNumberContainingIgnoreCase(vehicleNo);
    }


}
