package com.example.Vehicle.Registration.System.service;

import com.example.Vehicle.Registration.System.model.OrderSummary;
import com.example.Vehicle.Registration.System.repository.OrderSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSummaryService {

    @Autowired
    OrderSummaryRepository orderSummaryRepository;

    public List<OrderSummary> getAllOrderSummaries(){
        return orderSummaryRepository.findAll();
    }

}
