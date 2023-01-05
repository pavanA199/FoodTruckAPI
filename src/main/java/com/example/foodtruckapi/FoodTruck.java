package com.example.foodtruckapi;


import javax.persistence.*;

@Entity
@Table(name = "food_trucks")
public class FoodTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "applicant")
    private String applicant;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "location_description")
    private String locationDescription;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "location_address")
    private String locationAddress;

    @Column(name = "location_city")
    private String locationCity;

    @Column(name = "location_state")
    private String locationState;

    @Column(name = "location_zip")
    private String locationZip;

    @Column(name = "location_latitude")
    private String locationLatitude;

    @Column(name = "location_longitude")
    private String locationLongitude;

    public FoodTruck() {
    }

    public FoodTruck(String applicant, String expirationDate, String locationDescription, String locationId, String locationAddress, String locationZip, String locationLatitude, String locationLongitude) {
        this.applicant = applicant;
        this.expirationDate = expirationDate;
        this.locationDescription = locationDescription;
        this.locationId = locationId;
        this.locationAddress = locationAddress;
        this.locationZip = locationZip;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }

    public FoodTruck(String applicant, String expirationDate, String locationDescription, double latitude, double longitude) {
        this.applicant = applicant;
        this.expirationDate = expirationDate;
        this.locationDescription = locationDescription;
        this.locationLatitude = String.valueOf(latitude);
        this.locationLongitude = String.valueOf(longitude);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLocationDescription() {
        return locationDescription;
    }


    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationZip() {
        return locationZip;
    }

    public void setLocationZip(String locationZip) {
        this.locationZip = locationZip;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }
}

