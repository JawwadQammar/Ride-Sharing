package com.ridesharing.drivermanagement;

import com.ridesharing.drivermanagement.entity.DriverEntity;
import com.ridesharing.drivermanagement.repository.DriverRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(value = false)
public class DriverServiceImplTest {

    static long driverId;
    @Autowired
    private DriverRepository driverRepository;

    @Test
    @Order(1)
    void testCreateDriver () {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setName("Alpesh Desai");
        driverEntity.setLicenseNumber("ABC12345");
        driverEntity.setVehicleModel("SUV");

        DriverEntity savedDriver = driverRepository.save(driverEntity);
        driverId = savedDriver.getId();
        assertNotNull(savedDriver);
        assertEquals(driverId, savedDriver.getId());
        assertEquals("Alpesh Desai", savedDriver.getName());
        assertEquals("ABC12345", savedDriver.getLicenseNumber());
        assertEquals("SUV", savedDriver.getVehicleModel());
    }

    @Test
    @Order(2)
    void testGetDriverById () {
        DriverEntity retrievedDriver = driverRepository.findById(driverId).get();
        assertNotNull(retrievedDriver);
        assertEquals(driverId, retrievedDriver.getId());
        assertEquals("Alpesh Desai", retrievedDriver.getName());
        assertEquals("ABC12345", retrievedDriver.getLicenseNumber());
        assertEquals("SUV", retrievedDriver.getVehicleModel());
    }

    @Test
    @Order(3)
    void testUpdateDriver () {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setId(driverId);
        driverEntity.setName("Mukesh Desai");
        driverEntity.setLicenseNumber("XYZ67890");
        driverEntity.setVehicleModel("Sedan");

        driverRepository.save(driverEntity);
        DriverEntity driverEntityUpdated = driverRepository.findById(driverId).get();

        assertNotNull(driverEntityUpdated);
        assertEquals(driverId, driverEntityUpdated.getId());
        assertEquals("Mukesh Desai", driverEntityUpdated.getName());
        assertEquals("XYZ67890", driverEntityUpdated.getLicenseNumber());
        assertEquals("Sedan", driverEntityUpdated.getVehicleModel());
    }
}
