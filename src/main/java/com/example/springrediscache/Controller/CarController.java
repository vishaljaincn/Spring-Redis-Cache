package com.example.springrediscache.Controller;

import com.example.springrediscache.Model_Entity.Car;
import com.example.springrediscache.Service.CarService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Car entities.
 * Exposes endpoints for CRUD operations on cars.
 */
@RestController
@RequestMapping("/api/v1/cars") // Base path for all car-related endpoints
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * Retrieves a Car entity by its ID.
     *
     * @param id The unique identifier of the Car to retrieve.
     * @return The Car entity with the specified ID, or null if not found.
     * @Cacheable - caches the response for future requests with the same ID.
     */
    @GetMapping("/{id}")
    @Cacheable(value = "car")
    public Car fetchCarById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    /**
     * Retrieves all Car entities from the database.
     *
     * @return A list of all Car entities.
     * @Cacheable - caches the response for future requests.
     */
    @GetMapping("/getallcars")
    @Cacheable(value = "car")
    public List<Car> retrieveAllCars() {
        return carService.getAllCars();
    }

    /**
     * Creates a new Car entity.
     *
     * @param car The Car object containing company and model information.
     * @return The newly created Car entity.
     * @CachePut - updates the cache with the newly created car object.
     * Consider using @Caching for update operations to
     * invalidate existing cache entries and then create a new one.
     */
    @PostMapping("/addcar")
    @CachePut(value = "car", key = "#car.hashCode()") // Cache the created car object
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car.getCompany(), car.getModel());
    }
}
