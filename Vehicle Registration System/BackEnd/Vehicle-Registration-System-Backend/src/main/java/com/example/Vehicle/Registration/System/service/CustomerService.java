package com.example.Vehicle.Registration.System.service;

import com.example.Vehicle.Registration.System.DTO.CustomerDTO;
import com.example.Vehicle.Registration.System.DTO.VehicleDTO;
import com.example.Vehicle.Registration.System.model.Customer;
import com.example.Vehicle.Registration.System.model.OrderSummary;
import com.example.Vehicle.Registration.System.model.Vehicle;
import com.example.Vehicle.Registration.System.repository.CustomerRepository;
import com.example.Vehicle.Registration.System.repository.OrderSummaryRepository;
import com.example.Vehicle.Registration.System.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    OrderSummaryRepository orderSummaryRepository;

    public Customer registerCustomerWithVehicle(CustomerDTO customerDTO, VehicleDTO vehicleDTO){


        Customer customer = customerRepository.findByEmail(customerDTO.getEmail())
                .orElseGet(() -> {
                    Customer newCustomer = new Customer();
                    newCustomer.setName(customerDTO.getName());
                    newCustomer.setEmail(customerDTO.getEmail());
                    newCustomer.setPhone(customerDTO.getPhone());
                    return customerRepository.save(newCustomer);
                });


        if (vehicleRepository.existsById(vehicleDTO.getRegistrationNumber()) ) {
            throw new RuntimeException("Vehicle with this registration number already exists.");
        }

        // 1. Save customer
        /*
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer = customerRepository.save(customer);
         */

        // 2. Save Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setColor(vehicleDTO.getColor());
        vehicle.setCustomer(customer);
        vehicleRepository.save(vehicle);

        // 3. Create and save order summary !
        OrderSummary order = new OrderSummary();
        order.setCustomer(customer);
        order.setVehicle(vehicle);
        order.setRegistrationDate(LocalDate.now());
        order.setFee(100.0); // You can change logic to compute this
        order.setStatus("REGISTERED");
        orderSummaryRepository.save(order);

        return customer;

    }
}
