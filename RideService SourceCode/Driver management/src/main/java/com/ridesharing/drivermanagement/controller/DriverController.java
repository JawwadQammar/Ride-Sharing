package com.ridesharing.drivermanagement.controller;

import com.ridesharing.drivermanagement.entity.DriverEntity;
import com.ridesharing.drivermanagement.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController (DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public DriverEntity createDriver (@RequestBody DriverEntity driverEntity) {
        return driverService.createDriver(driverEntity);
    }

    @GetMapping("/{driverId}")
    public DriverEntity getDriver (@PathVariable Long driverId) {
        return driverService.getDriverById(driverId);
    }

    @PutMapping("/{driverId}")
    public DriverEntity updateDriver (@PathVariable Long driverId, @RequestBody DriverEntity updatedDriver) {
        return driverService.updateDriver(driverId, updatedDriver);
    }

    @GetMapping
    public List<DriverEntity> getAllDrivers () {
        return driverService.getAllDrivers();
    }
}
