package com.example.foodtruckapi;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class FoodTruckService {


    @Autowired
    FoodTruckRepository repository;

    public void loadCsvFileIntoDatabase(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<FoodTruck> foodTrucks = mapCsvToFoodTruckList(reader);
            repository.saveAll(foodTrucks);
        }
    }


    public List<FoodTruck> mapCsvToFoodTruckList(Reader reader) throws IOException {
        List<FoodTruck> foodTrucks = new ArrayList<>();
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for (CSVRecord record : parser) {
            String applicant = record.get("Applicant");
            String locationDescription = record.get("LocationDescription");
            String locationId = record.get("locationid");
            String locationAddress = record.get("Address");
            String locationZip = record.get("Zip Codes");
            String locationLatitude = record.get("Latitude");
            String locationLongitude = record.get("Longitude");
            String expirationDate = record.get("ExpirationDate");

            foodTrucks.add(new FoodTruck(applicant, expirationDate, locationDescription, locationId, locationAddress, locationZip, locationLatitude, locationLongitude));
        }
        return foodTrucks;
    }


    public List<FoodTruck> getByApplicantExpired(String expDate) {
        return new ArrayList<>(repository.findByExpirationDate(expDate));
    }

    public List<FoodTruck> getAllApplicant() {
        return new ArrayList<>(repository.findAll());
    }

    public List<FoodTruck> getByApplicantByName(String applicant) {
        return new ArrayList<>(repository.findByApplicant(applicant));
    }

    public List<FoodTruck> findByStreetName(String streetName) {
        return repository.findByLocationAddressContainingIgnoreCase(streetName);
    }

    public <S extends FoodTruck> S save(S foodTruck) {
        return repository.save(foodTruck);
    }

    public FoodTruck findClosest(Double latitude, Double longitude) {
        List<FoodTruck> trucks = repository.findAll();

        FoodTruck closestTruck = null;
        double closestDistance = Double.MAX_VALUE;  // Initialize to a large value

        for (FoodTruck truck : trucks) {
            System.out.println(truck);
            double truckLat = Double.parseDouble(truck.getLocationLatitude());
            double truckLng = Double.parseDouble(truck.getLocationLongitude());

            double distance = distance(latitude, longitude, truckLat, truckLng);
            System.out.println(distance);
            if (distance < closestDistance) {
                closestTruck = truck;
                closestDistance = distance;
            }
        }

        return closestTruck;
    }


    public double distance(double lat1, double lng1, double lat2, double lng2) {
        double dlat = Math.toRadians(lat2 - lat1);
        double dlng = Math.toRadians(lng2 - lng1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlng / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return c;
    }


}
