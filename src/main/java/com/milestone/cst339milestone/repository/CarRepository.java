package com.milestone.cst339milestone.repository;

import com.milestone.cst339milestone.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findById(String id);

    void deleteById(String id);
}
