package com.example.Vehicle.Registration.System.controller;

import com.example.Vehicle.Registration.System.DTO.RegistrationRequest;
import com.example.Vehicle.Registration.System.model.Customer;
import com.example.Vehicle.Registration.System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomerWithVehicle(@RequestBody RegistrationRequest request){

        Customer customer = customerService.registerCustomerWithVehicle(request.getCustomer(),request.getVehicle());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
