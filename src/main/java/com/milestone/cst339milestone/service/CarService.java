package com.milestone.cst339milestone.service;

import com.milestone.cst339milestone.model.Car;
import com.milestone.cst339milestone.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(String id) {
        return carRepository.findById(id);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }
}

