package com.example.foodtruckapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

    List<FoodTruck> findByExpirationDate(String expirationDate);

    List<FoodTruck> findByApplicant(String applicant);

    List<FoodTruck> findByLocationAddressContainingIgnoreCase(String locationAddress);


}