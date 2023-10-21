package com.ridesharing.passengermanagement.service;

import com.ridesharing.passengermanagement.dto.PassengerDTO;
import com.ridesharing.passengermanagement.entity.PassengerEntity;
import com.ridesharing.passengermanagement.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl (PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public PassengerDTO createPassenger (PassengerDTO passengerDTO) {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setName(passengerDTO.getName());
        passengerEntity.setEmail(passengerDTO.getEmail());
        passengerEntity.setPhone(passengerDTO.getPhone());
        passengerEntity = passengerRepository.save(passengerEntity);

        return convertToDTO(passengerEntity);
    }

    @Override
    public PassengerDTO getPassengerById (Long passengerId) {
        PassengerEntity passengerEntity = passengerRepository.findById(passengerId).orElse(null);
        if (passengerEntity != null) {
            return convertToDTO(passengerEntity);
        } else {
            return null; // Handle not found case appropriately
        }
    }

    @Override
    public PassengerDTO updatePassenger (Long passengerId, PassengerDTO updatedPassenger) {
        PassengerEntity passengerEntity = passengerRepository.findById(passengerId).orElse(null);
        if (passengerEntity != null) {
            // Update passengerEntity with data from updatedPassenger
            passengerEntity.setName(updatedPassenger.getName());
            passengerEntity.setEmail(updatedPassenger.getEmail());
            passengerEntity.setPhone(updatedPassenger.getPhone());
            passengerEntity = passengerRepository.save(passengerEntity);

            return convertToDTO(passengerEntity);
        } else {
            return null; // Handle not found case appropriately
        }
    }

    @Override
    public List<PassengerDTO> getAllPassengers () {
        List<PassengerEntity> passengerEntities = passengerRepository.findAll();
        return passengerEntities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PassengerDTO convertToDTO (PassengerEntity passengerEntity) {
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setId(passengerEntity.getId());
        passengerDTO.setName(passengerEntity.getName());
        passengerDTO.setEmail(passengerEntity.getEmail());
        passengerDTO.setPhone(passengerEntity.getPhone());
        return passengerDTO;
    }
}
