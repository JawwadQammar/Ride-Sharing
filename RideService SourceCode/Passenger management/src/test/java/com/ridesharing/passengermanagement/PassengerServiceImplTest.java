package com.ridesharing.passengermanagement;

import com.ridesharing.passengermanagement.entity.PassengerEntity;
import com.ridesharing.passengermanagement.repository.PassengerRepository;
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
public class PassengerServiceImplTest {

    static long passengerId;
    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    @Order(1)
    void testCreatePassenger () {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setName("Alpesh Desai");
        passengerEntity.setEmail("alpesh@test.com");
        passengerEntity.setPhone("9898989898");
        PassengerEntity savedPassenger = passengerRepository.save(passengerEntity);
        passengerId = savedPassenger.getId();
        assertNotNull(savedPassenger);
        assertEquals(passengerId, savedPassenger.getId());
        assertEquals("Alpesh Desai", savedPassenger.getName());
        assertEquals("alpesh@test.com", savedPassenger.getEmail());
        assertEquals("9898989898", savedPassenger.getPhone());
    }

    @Test
    @Order(2)
    void testGetPassengerById () {

        PassengerEntity retrievedPassenger = passengerRepository.findById(passengerId).get();
        assertNotNull(retrievedPassenger);
        assertEquals(passengerId, retrievedPassenger.getId());
        assertEquals("Alpesh Desai", retrievedPassenger.getName());
        assertEquals("alpesh@test.com", retrievedPassenger.getEmail());
        assertEquals("9898989898", retrievedPassenger.getPhone());
    }

    @Test
    @Order(3)
    void testUpdatePassenger () {
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setId(passengerId);
        passengerEntity.setName("Mukesh Desai");
        passengerEntity.setEmail("mukesh@example.com");
        passengerEntity.setPhone("9090909090");

        passengerRepository.save(passengerEntity);
        PassengerEntity passengerEntityUpdated = passengerRepository.findById(passengerId).get();


        assertNotNull(passengerEntityUpdated);
        assertEquals(passengerId, passengerEntityUpdated.getId());
        assertEquals("Mukesh Desai", passengerEntityUpdated.getName());
        assertEquals("mukesh@example.com", passengerEntityUpdated.getEmail());
        assertEquals("9090909090", passengerEntityUpdated.getPhone());
    }
}

