package com.milestone.cst339milestone.controller;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Car Rest Controller specifically used to handle REST endpoints
@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}
