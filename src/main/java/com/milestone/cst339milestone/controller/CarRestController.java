package com.milestone.cst339milestone.controller;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * CarRestController handles RESTful web service requests for car resources.
 */
@RestController
@RequestMapping("/api/cars")
public class CarRestController {

    @Autowired
    private CarService carService;

    /**
     * Retrieves a list of all cars.
     *
     * @return A list of Car objects.
     */
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    /**
     * Retrieves a car by its ID.
     *
     * @param id The ID of the car to retrieve.
     * @return A ResponseEntity containing the car object if found, or an appropriate HTTP status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") String id) {
        try {
            Optional<Car> car = carService.getCarById(id);
            if (car.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(car.get(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
