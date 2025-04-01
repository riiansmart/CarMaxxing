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

/**
 * CarController handles web requests related to car management operations such as listing, adding, editing, and deleting cars.
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * Displays the car listing page with all cars.
     *
     * @param model The model to pass attributes to the view.
     * @return The name of the Thymeleaf template for the car listing page.
     */
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

    /**
     * Adds a new car to the listing.
     *
     * @param car The car object to be added.
     * @return A redirect to the car listing page.
     */
    @PostMapping("/ListCar")
    public String addCar(@ModelAttribute("car") Car car) {
        carService.addCar(car); 
        return "redirect:/cars/CarListing";
    }

    /**
     * Deletes a car from the listing by ID.
     *
     * @param id The ID of the car to delete.
     * @return A redirect to the car listing page.
     */
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable("id") String id) {
        carService.deleteCar(id);
        return "redirect:/cars/CarListing";
    }

    /**
     * Displays the form for editing a car.
     *
     * @param id The ID of the car to edit.
     * @param model The model to pass attributes to the view.
     * @return The name of the Thymeleaf template for the edit car page.
     */
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

    /**
     * Updates the details of a car.
     *
     * @param id The ID of the car to update.
     * @param car The car object containing updated details.
     * @return A redirect to the car listing page.
     */
    @PostMapping("/edit/{id}")
    public String editCar(@PathVariable("id") String id, @ModelAttribute("car") Car car) {
        car.setId(id);
        carService.updateCar(car);
        return "redirect:/cars/CarListing";
    }

    /**
     * Displays a fixed car edit form, primarily for testing.
     *
     * @param model The model to pass attributes to the view.
     * @return The name of the Thymeleaf template for the edit car page.
     */
    @GetMapping("/EditCar")
    public String editCarFormFixed(Model model) {
        String fixedId = "some-fixed-id"; // Replace this with an actual ID for testing
        Car car = carService.getCarById(fixedId).orElse(null);
        if (car == null) {
            return "redirect:/cars/CarListing"; // Handle the case where the car is not found
        }
        model.addAttribute("car", car);
        model.addAttribute("title", "Edit Car");
        return "EditCar";
    }

    /**
     * Displays the form for removing a car.
     *
     * @param model The model to pass attributes to the view.
     * @return The name of the Thymeleaf template for the remove car page.
     */
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

    /**
     * Removes a car from the listing.
     *
     * @param car The car object to remove.
     * @return A redirect to the car listing page.
     */
    @PostMapping("/remove")
    public String removeCar(@ModelAttribute("car") Car car) {
        carService.deleteCar(car.getId());
        return "redirect:/cars/CarListing";
    }
}
