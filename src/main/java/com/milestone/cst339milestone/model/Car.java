package com.milestone.cst339milestone.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a Car entity in the MongoDB collection "cars".
 */
@Document(collection = "cars")
public class Car {

    /**
     * The unique identifier for the car, represented as a String.
     * This is used for MongoDB's ObjectId.
     */
    @Id
    private String id;

    /**
     * The make of the car.
     */
    private String make;

    /**
     * The model of the car.
     */
    private String model;

    /**
     * The manufacturing year of the car.
     */
    private int year;

    /**
     * The color of the car.
     */
    private String color;

    /**
     * Default constructor.
     */
    public Car() {
    }

    /**
     * Constructs a new Car with the specified make, model, year, and color.
     *
     * @param make  The make of the car.
     * @param model The model of the car.
     * @param year  The manufacturing year of the car.
     * @param color The color of the car.
     */
    public Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    /**
     * Constructs a new Car with the specified id, make, model, year, and color.
     *
     * @param id    The unique identifier for the car.
     * @param make  The make of the car.
     * @param model The model of the car.
     * @param year  The manufacturing year of the car.
     * @param color The color of the car.
     */
    public Car(String id, String make, String model, int year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    /**
     * Returns the unique identifier of the car.
     *
     * @return The car's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the car.
     *
     * @param id The new id for the car.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the make of the car.
     *
     * @return The car's make.
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the car.
     *
     * @param make The new make for the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Returns the model of the car.
     *
     * @return The car's model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the car.
     *
     * @param model The new model for the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Returns the manufacturing year of the car.
     *
     * @return The car's year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the manufacturing year of the car.
     *
     * @param year The new year for the car.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns the color of the car.
     *
     * @return The car's color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the car.
     *
     * @param color The new color for the car.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a string representation of the car.
     *
     * @return A string containing the car's id, make, model, year, and color.
     */
    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
