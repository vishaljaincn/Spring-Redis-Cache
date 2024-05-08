package com.example.springrediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The main Spring Boot application class for enabling Redis caching.
 */
@SpringBootApplication
@EnableCaching
public class SpringRedisCacheApplication {

    /**
     * Main method to start the Spring Boot application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringRedisCacheApplication.class, args);
    }

}
