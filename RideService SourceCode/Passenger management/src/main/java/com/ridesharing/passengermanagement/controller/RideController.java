package com.ridesharing.passengermanagement.controller;

import com.ridesharing.passengermanagement.dto.RideRequestDTO;
import com.ridesharing.passengermanagement.dto.RideResponseDTO;
import com.ridesharing.passengermanagement.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @PostMapping("/request-ride")
    public ResponseEntity<RideResponseDTO> requestRide (@RequestBody RideRequestDTO rideRequestDTO) {
        return new ResponseEntity<>(rideService.requestRide(rideRequestDTO), HttpStatus.OK);
    }
    //TODO confirm the ride will implement in DriverService


}
