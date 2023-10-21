package com.ridesharing.billingmanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BillingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long passengerId;
    private Long driverId;
    private String rideDistance;
    private double totalAmount;

    public BillingEntity () {
    }

    public BillingEntity (Long id, Long passengerId, Long driverId, String rideDistance, double totalAmount) {
        this.id = id;
        this.passengerId = passengerId;
        this.driverId = driverId;
        this.rideDistance = rideDistance;
        this.totalAmount = totalAmount;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
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

    public String getRideDistance () {
        return rideDistance;
    }

    public void setRideDistance (String rideDistance) {
        this.rideDistance = rideDistance;
    }

    public double getTotalAmount () {
        return totalAmount;
    }

    public void setTotalAmount (double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
