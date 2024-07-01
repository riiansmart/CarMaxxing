package com.milestone.cst339milestone.repository;

import com.milestone.cst339milestone.model.Car;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CarRepository {
    Car car = new Car();
    private List<Car> cars = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Car> findAll() {
        return new ArrayList<>(cars);
    }

    public Optional<Car> findById(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst();
    }

    public Car save(Car car) {
        if (car.getId() == null) {
            car.setId(idCounter.incrementAndGet());
        }
        cars.add(car);
        return car;
    }

    public void deleteById(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}
