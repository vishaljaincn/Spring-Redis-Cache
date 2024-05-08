package com.example.springrediscache.Repository;

import com.example.springrediscache.Model_Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface defines a repository for Car entities.
 * It extends JpaRepository provided by Spring Data JPA,
 * which offers pre-built methods for basic CRUD (Create, Read, Update, Delete)
 * operations on Car entities.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}
