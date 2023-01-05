package com.example.foodtruckapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import java.util.List;


@RestController
@RequestMapping("/api/foodtrucks")
public class FoodTruckController {


    @Autowired
    FoodTruckService foodTruckService;

    @Autowired
    FoodTruckRepository repository;


    @PostMapping("/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        foodTruckService.loadCsvFileIntoDatabase(file.getInputStream());
    }
    @GetMapping("/applicant")
    public List<FoodTruck> findByApplicant() {
        return foodTruckService.getAllApplicant();
    }
    @GetMapping("/getApplicant")
    public List<FoodTruck> getByApplicantName(@RequestParam String app) {
        return foodTruckService.getByApplicantByName(app);
    }


    @GetMapping("/expired")
    public List<FoodTruck> findExpiredTrucks(@RequestParam String expirationDate) {
     return foodTruckService.getByApplicantExpired(expirationDate);
    }


    @GetMapping("/street")
    public List<FoodTruck> findByStreetName(@RequestParam String streetName) {
        return foodTruckService.findByStreetName(streetName);
    }

    @PostMapping("/foodtrucks")
    public FoodTruck addFoodTruck(@RequestBody FoodTruck foodTruck) {
        return foodTruckService.save(foodTruck);
    }

    @GetMapping("/closest")
    public FoodTruck findClosest(@RequestParam Double latitude, @RequestParam Double longitude) {
        return foodTruckService.findClosest(latitude, longitude);
    }
}
