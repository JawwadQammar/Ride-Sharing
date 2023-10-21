package com.ridesharing.passengermanagement.dto;

public class RideRequestDTO {
    private Long passengerId;
    private Long driverId;
    private String startLocation;
    private String endLocation;

    public RideRequestDTO () {
    }

    public RideRequestDTO (Long passengerId, Long driverId, String startLocation, String endLocation) {
        this.passengerId = passengerId;
        this.driverId = driverId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    public Long getPassengerId () {
        return passengerId;
    }

    public void setPassengerId (Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getDriverId () {
        return driverId;
    }

    public void setDriverId (Long driverId) {
        this.driverId = driverId;
    }

    public String getStartLocation () {
        return startLocation;
    }

    public void setStartLocation (String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation () {
        return endLocation;
    }

    public void setEndLocation (String endLocation) {
        this.endLocation = endLocation;
    }
}

