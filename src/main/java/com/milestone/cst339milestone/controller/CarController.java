package com.milestone.cst339milestone.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.service.CarService;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/carListing")
    public String showCarListing(Model model) {
        List<Car> carList = carService.getAllCars();
        if (carList == null) {
            carList = new ArrayList<>();
        }
        model.addAttribute("carList", carList);
        return "CarListing";
    }
}

