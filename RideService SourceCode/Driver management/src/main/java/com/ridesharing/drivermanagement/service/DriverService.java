package com.ridesharing.drivermanagement.service;


import com.ridesharing.drivermanagement.entity.DriverEntity;

import java.util.List;

public interface DriverService {
    DriverEntity createDriver (DriverEntity driverEntity);

    DriverEntity getDriverById (Long driverId);

    DriverEntity updateDriver (Long driverId, DriverEntity updatedDriver);

    List<DriverEntity> getAllDrivers ();
}
