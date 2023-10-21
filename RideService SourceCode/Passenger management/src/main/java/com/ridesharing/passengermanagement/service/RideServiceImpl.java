package com.ridesharing.passengermanagement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridesharing.passengermanagement.dto.*;
import com.ridesharing.passengermanagement.entity.PassengerEntity;
import com.ridesharing.passengermanagement.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RideServiceImpl implements RideService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RideResponseDTO requestRide (RideRequestDTO rideRequestDTO) {
        RideResponseDTO rideResponseDTO = new RideResponseDTO();
        Optional<PassengerEntity> passengerRepositoryById = passengerRepository.findById(rideRequestDTO.getPassengerId());
        if (!passengerRepositoryById.isPresent()) throw new IllegalStateException("Passenger is not present");

        rideResponseDTO.setPassengerDTO(new ObjectMapper().convertValue(passengerRepositoryById.get(), PassengerDTO.class));
        DriverDTO driverDTO = getDriverById(rideRequestDTO.getDriverId());
        if (driverDTO.getId() == null) throw new IllegalStateException("Driver is not present");
        rideResponseDTO.setDriverDTO(driverDTO);

        String rideDistance = getRideDistance(rideRequestDTO.getStartLocation(), rideRequestDTO.getEndLocation());
        double totalAmount = getTotalAmount(rideRequestDTO.getStartLocation(), rideRequestDTO.getEndLocation());

        BillingDTO billingDTO = generateBill(rideRequestDTO.getPassengerId(), rideRequestDTO.getDriverId(), rideDistance, totalAmount);
        rideResponseDTO.setBillingDTO(billingDTO);

        return rideResponseDTO;
    }

    private double getTotalAmount (String startLocation, String endLocation) {
        //TODO add logic for total amount calculation
        return 1500;
    }

    private String getRideDistance (String startLocation, String endLocation) {
        //TODO add logic for ride distance calculation
        return "10KM";
    }

    public DriverDTO getDriverById (Long driverId) {
        String driverServiceUrl = "lb://DRIVER-MANAGEMENT/driver/" + driverId;
        ResponseEntity<DriverDTO> response = restTemplate.exchange(driverServiceUrl, HttpMethod.GET, null, DriverDTO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            //TODO Handle errors or return null if the driver is not found
            return null;
        }
    }

    public BillingDTO generateBill (Long passengerId, Long driverId, String rideDistance, double totalAmount) {
        String billingServiceUrl = "lb://BILLING-MANAGEMENT/billing/"; // Replace with your Billing service URL
        BillingDTO billRequest = new BillingDTO(null, passengerId, driverId, rideDistance, totalAmount);
        ResponseEntity<BillingDTO> response = restTemplate.postForEntity(billingServiceUrl, billRequest, BillingDTO.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            //TODO Handle errors or return null if bill generation fails
            return null;
        }
    }
}
