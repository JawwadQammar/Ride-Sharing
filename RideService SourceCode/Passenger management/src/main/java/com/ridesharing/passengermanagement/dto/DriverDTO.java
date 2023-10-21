package com.ridesharing.passengermanagement.dto;

public class DriverDTO {
    private Long id;
    private String name;
    private String licenseNumber;
    private String vehicleModel;


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
