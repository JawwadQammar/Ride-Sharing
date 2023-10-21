package com.ridesharing.drivermanagement.service;

import com.ridesharing.drivermanagement.entity.DriverEntity;
import com.ridesharing.drivermanagement.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverEntity createDriver (DriverEntity driverEntity) {

        return driverRepository.save(driverEntity);

    }

    @Override
    public DriverEntity getDriverById (Long driverId) {
        DriverEntity driverEntity = driverRepository.findById(driverId).orElse(null);
        if (driverEntity != null) {
            return driverEntity;
        } else {
            return null; // Handle not found case appropriately
        }
    }

    @Override
    public DriverEntity updateDriver (Long driverId, DriverEntity updatedDriver) {
        DriverEntity driverEntity = driverRepository.findById(driverId).orElse(null);
        if (driverEntity != null) {
            // Update driverEntity with data from updatedDriver
            driverEntity.setName(updatedDriver.getName());
            driverEntity.setLicenseNumber(updatedDriver.getLicenseNumber());
            driverEntity.setVehicleModel(updatedDriver.getVehicleModel());
            driverEntity = driverRepository.save(driverEntity);

            return driverEntity;
        } else {
            return null; //TODO Handle not found case appropriately
        }
    }

    @Override
    public List<DriverEntity> getAllDrivers () {
        return driverRepository.findAll();
    }

}
