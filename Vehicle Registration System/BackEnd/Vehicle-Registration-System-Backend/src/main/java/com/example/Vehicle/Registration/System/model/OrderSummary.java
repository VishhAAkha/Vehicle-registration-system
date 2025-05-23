package com.example.Vehicle.Registration.System.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class OrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Vehicle vehicle;

    @ManyToOne
    private Customer customer;

    private LocalDate registrationDate;

    private double fee;

    private String status;


}
