package com.example.springrediscache.Service;

import com.example.springrediscache.Model_Entity.Car;
import com.example.springrediscache.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class defines a service for managing Car entities.
 * It interacts with the CarRepository to perform CRUD operations
 * (Create, Read, Update, Delete) on car data.
 */
@Service
public class CarService {

    /**
     * Injected dependency of the CarRepository.
     * This field provides access to methods for interacting with Car entities
     * in the database.
     */
    private final CarRepository carRepository;

    /**
     * Constructor to inject the CarRepository dependency.
     *
     * @param carRepository The CarRepository instance used for data access.
     */
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Retrieves a Car entity from the database by its ID.
     *
     * @param id The unique identifier of the Car to retrieve.
     * @return The Car entity with the specified ID, or null if not found.
     */
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null); // Safer alternative to get()
    }

    /**
     * Retrieves all Car entities from the database.
     *
     * @return A list of all Car entities in the database.
     */
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    /**
     * Creates a new Car entity and persists it to the database.
     *
     * @param company The name of the car company.
     * @param model   The specific model of the car.
     * @return The newly created Car entity.
     */
    public Car createCar(String company, String model) {
        Car car = new Car();
        car.setCompany(company);
        car.setModel(model);

        carRepository.save(car);

        return car;
    }
}
