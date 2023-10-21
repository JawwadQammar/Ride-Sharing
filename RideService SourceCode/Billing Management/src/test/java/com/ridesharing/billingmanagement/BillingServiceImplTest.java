package com.ridesharing.billingmanagement;

import com.ridesharing.billingmanagement.entity.BillingEntity;
import com.ridesharing.billingmanagement.repository.BillingRepository;
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
public class BillingServiceImplTest {

    static long billingId;
    @Autowired
    private BillingRepository billingRepository;

    @Test
    @Order(1)
    void testCreateBilling () {
        BillingEntity billingEntity = new BillingEntity();
        billingEntity.setPassengerId(1L);
        billingEntity.setDriverId(2L);
        billingEntity.setRideDistance("1KM");
        billingEntity.setTotalAmount(30.0);

        BillingEntity savedBilling = billingRepository.save(billingEntity);
        billingId = savedBilling.getId();
        assertNotNull(savedBilling);
        assertEquals(billingId, savedBilling.getId());
        assertEquals(1L, savedBilling.getPassengerId());
        assertEquals(2L, savedBilling.getDriverId());
        assertEquals("1KM", savedBilling.getRideDistance());
        assertEquals(30.0, savedBilling.getTotalAmount());
    }

    @Test
    @Order(2)
    void testGetBillingById () {
        BillingEntity retrievedBilling = billingRepository.findById(billingId).get();
        assertNotNull(retrievedBilling);
        assertEquals(billingId, retrievedBilling.getId());
        assertEquals(1L, retrievedBilling.getPassengerId());
        assertEquals(2L, retrievedBilling.getDriverId());
        assertEquals("1KM", retrievedBilling.getRideDistance());
        assertEquals(30.0, retrievedBilling.getTotalAmount());
    }
}
