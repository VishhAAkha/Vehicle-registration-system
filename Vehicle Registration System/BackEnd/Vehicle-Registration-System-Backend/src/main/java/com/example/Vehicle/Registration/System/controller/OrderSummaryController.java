package com.example.Vehicle.Registration.System.controller;

import com.example.Vehicle.Registration.System.model.OrderSummary;
import com.example.Vehicle.Registration.System.service.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class OrderSummaryController {

    @Autowired
    OrderSummaryService orderSummaryService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderSummary>> getAllOrderSummaries() {
        return new ResponseEntity<>(orderSummaryService.getAllOrderSummaries(), HttpStatus.OK);
    }

}
