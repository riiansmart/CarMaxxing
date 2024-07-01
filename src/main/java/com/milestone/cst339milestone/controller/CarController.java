package com.milestone.cst339milestone.controller;

import java.util.ArrayList;
import java.util.List;
import com.milestone.cst339milestone.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.milestone.cst339milestone.model.Car;
@Controller
public class CarController {
    @GetMapping("/carListing")
    public String showCarListing(Model model) {
        CarService carService = new CarService();
        List<Car> carList = carService.getAllCars();
        if (carList == null) {
            carList = new ArrayList<>();
        }
        model.addAttribute("carList", carList);
        return "CarListing";
    }
}
