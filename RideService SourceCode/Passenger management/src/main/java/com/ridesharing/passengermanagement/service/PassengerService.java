package com.ridesharing.passengermanagement.service;

import com.ridesharing.passengermanagement.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
    PassengerDTO createPassenger (PassengerDTO passengerDTO);

    PassengerDTO getPassengerById (Long passengerId);

    PassengerDTO updatePassenger (Long passengerId, PassengerDTO updatedPassenger);

    List<PassengerDTO> getAllPassengers ();
}

