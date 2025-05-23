package com.example.Vehicle.Registration.System.DTO;

import lombok.Data;

@Data
public class RegistrationRequest {

    private CustomerDTO customer;
    private VehicleDTO vehicle;

}
