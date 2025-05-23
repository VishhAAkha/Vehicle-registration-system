package com.example.Vehicle.Registration.System.repository;

import com.example.Vehicle.Registration.System.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    List<Vehicle> findByRegistrationNumberContainingIgnoreCase(String vehicleNo);

}
