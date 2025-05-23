package com.example.Vehicle.Registration.System.service;

import com.example.Vehicle.Registration.System.model.Vehicle;
import com.example.Vehicle.Registration.System.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }


    public List<Vehicle> findByRegistrationNumberContainingIgnoreCase(String vehicleNo) {
        return vehicleRepository.findByRegistrationNumberContainingIgnoreCase(vehicleNo);
    }
}
