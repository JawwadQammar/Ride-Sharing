package com.ridesharing.passengermanagement.service;

import com.ridesharing.passengermanagement.dto.RideRequestDTO;
import com.ridesharing.passengermanagement.dto.RideResponseDTO;

public interface RideService {
    RideResponseDTO requestRide (RideRequestDTO rideRequestDTO);
}
