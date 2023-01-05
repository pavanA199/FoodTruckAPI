package com.example.foodtruckapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FoodTruckApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodTruckApiApplication.class, args);
	}

}
