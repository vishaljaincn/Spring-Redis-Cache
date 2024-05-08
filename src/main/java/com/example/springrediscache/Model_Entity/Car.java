package com.example.springrediscache.Model_Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

/**
 * This class represents a Car entity in the application.
 * It maps to a table in the database and defines the attributes
 * of a car.
 */
@Entity
@Data // This Lombok annotation automatically generates getters, setters, equals, hashCode, and toString methods
public class Car implements Serializable {

    /**
     * Unique identifier for the Car entity.
     * This field is marked as the primary key (Id) and is auto-generated
     * using the GenerationType.AUTO strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The company that manufactured the car.
     */
    private String company;

    /**
     * The specific model of the car.
     */
    private String model;

}
