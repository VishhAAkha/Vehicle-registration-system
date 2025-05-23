package com.example.Vehicle.Registration.System.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class OrderSummaryDTO {
    private Long id;
    private String vehicleRegistrationNumber;
    private String customerName;
    private LocalDate registrationDate;
    private double fee;
    private String status;
}
