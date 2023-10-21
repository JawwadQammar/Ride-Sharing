package com.ridesharing.passengermanagement.dto;

public class RideResponseDTO {
    private PassengerDTO passengerDTO;
    private DriverDTO driverDTO;
    private BillingDTO billingDTO;

    public RideResponseDTO (PassengerDTO passengerDTO, DriverDTO driverDTO, BillingDTO billingDTO) {
        this.passengerDTO = passengerDTO;
        this.driverDTO = driverDTO;
        this.billingDTO = billingDTO;
    }

    public RideResponseDTO () {
    }

    public PassengerDTO getPassengerDTO () {
        return passengerDTO;
    }

    public void setPassengerDTO (PassengerDTO passengerDTO) {
        this.passengerDTO = passengerDTO;
    }

    public DriverDTO getDriverDTO () {
        return driverDTO;
    }

    public void setDriverDTO (DriverDTO driverDTO) {
        this.driverDTO = driverDTO;
    }

    public BillingDTO getBillingDTO () {
        return billingDTO;
    }

    public void setBillingDTO (BillingDTO billingDTO) {
        this.billingDTO = billingDTO;
    }
}
