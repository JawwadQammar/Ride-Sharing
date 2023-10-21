package com.ridesharing.drivermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private String vehicleModel;

    public DriverEntity () {
    }

    public DriverEntity (Long id, String name, String licenseNumber, String vehicleModel) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.vehicleModel = vehicleModel;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getLicenseNumber () {
        return licenseNumber;
    }

    public void setLicenseNumber (String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleModel () {
        return vehicleModel;
    }

    public void setVehicleModel (String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
