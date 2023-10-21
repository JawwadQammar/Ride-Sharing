package com.ridesharing.passengermanagement.controller;

import com.ridesharing.passengermanagement.dto.PassengerDTO;
import com.ridesharing.passengermanagement.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController (PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public PassengerDTO createPassenger (@RequestBody PassengerDTO passengerDTO) {
        return passengerService.createPassenger(passengerDTO);
    }

    @GetMapping("/{passengerId}")
    public PassengerDTO getPassenger (@PathVariable Long passengerId) {
        return passengerService.getPassengerById(passengerId);
    }

    @PutMapping("/{passengerId}")
    public PassengerDTO updatePassenger (@PathVariable Long passengerId, @RequestBody PassengerDTO updatedPassenger) {
        return passengerService.updatePassenger(passengerId, updatedPassenger);
    }

    @GetMapping
    public List<PassengerDTO> getAllPassengers () {
        return passengerService.getAllPassengers();
    }
}
