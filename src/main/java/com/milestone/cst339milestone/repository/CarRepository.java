package com.milestone.cst339milestone.repository;

import com.milestone.cst339milestone.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Repository interface for managing Car entities.
 * This interface extends Mongo Repo to provide CRUD operations for Car entities,
 * including custom query methods for finding and deleting cars by their ID.
 */
public interface CarRepository extends MongoRepository<Car, String> {

    /**
     * Finds a Car entity by its ID.
     * 
     * @param id The ID of the car to find.
     * @return An Optional containing the found car if present, otherwise empty.
     */
    Optional<Car> findById(String id);

    /**
     * Deletes a Car entity by its ID.
     * 
     * @param id The ID of the car to delete.
     */
    void deleteById(String id);
}
