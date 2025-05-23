package com.example.Vehicle.Registration.System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vehicle", uniqueConstraints = {
        @UniqueConstraint(columnNames = "registrationNumber")
})
public class Vehicle {

    @Id
    private String registrationNumber;
    private String type;
    private String model;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Customer customer;
}
