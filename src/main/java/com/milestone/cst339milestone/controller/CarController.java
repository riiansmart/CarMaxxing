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
        model.addAttribute("title", "Car Listing");
        return "CarListing";
    }

    @PostMapping("/ListCar")
    public String addCar(@ModelAttribute("car") Car car) {
        // Handle adding car logic
        carService.addCar(car); 
        return "redirect:/cars/CarListing";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable("id") String id) {
        carService.deleteCar(id);
        return "redirect:/cars/CarListing";
    }


    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable("id") String id, Model model) {
        Car car = carService.getCarById(id).orElse(null);
        if (car == null) {
            return "redirect:/cars/CarListing"; // Handle the case where the car is not found
        }
        model.addAttribute("car", car);
        model.addAttribute("title", "Edit Car");
        return "EditCar";
    }

    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable("id") String id, @ModelAttribute("car") Car car) {
        car.setId(id);
        carService.updateCar(car);
        return "redirect:/cars/CarListing";
    }

    @GetMapping("/EditCar")
    public String editCarFormFixed(Model model) {
        // Assuming there is a car with ID "some-fixed-id" for demonstration purposes
        String fixedId = "some-fixed-id"; // Replace this with an actual ID for testing
        Car car = carService.getCarById(fixedId).orElse(null);
        if (car == null) {
            return "redirect:/cars/CarListing"; // Handle the case where the car is not found
        }
        model.addAttribute("car", car);
        model.addAttribute("title", "Edit Car");
        return "EditCar";
    }

    // Handles the GET request for RemoveCar page
    @GetMapping("/remove")
    public String showRemoveCarForm(Model model) {
        List<Car> carList = carService.getAllCars();
        if (carList == null) {
            carList = new ArrayList<>();
        }
        model.addAttribute("carList", carList);
        model.addAttribute("car", new Car()); // This will bind the selected car for removal
        return "RemoveCar";
    }

    // Handles removing Car object from page
    @PostMapping("/remove")
    public String removeCar(@ModelAttribute("car") Car car) {
        carService.deleteCar(car.getId());
        return "redirect:/cars/CarListing";
    }

}
