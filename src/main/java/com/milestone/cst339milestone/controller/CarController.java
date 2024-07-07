package com.milestone.cst339milestone.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/CarListing")
    public String showCarListing(Model model) {
        List<Car> carList = carService.getAllCars();
        if (carList == null) {
            carList = new ArrayList<>();
        }
        model.addAttribute("carList", carList);
        return "CarListing";
    }
    @PostMapping("")
    public String addCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/CarListing";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable("id") String id) {
        carService.deleteCar(id);
        return "redirect:/CarListing";
    }
}

