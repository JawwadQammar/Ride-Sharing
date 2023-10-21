package com.ridesharing.billingmanagement.service;

import com.ridesharing.billingmanagement.entity.BillingEntity;
import com.ridesharing.billingmanagement.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingServiceImpl (BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public BillingEntity createBilling (BillingEntity billingEntity) {
        return billingRepository.save(billingEntity);

    }

    @Override
    public BillingEntity getBillingById (Long billingId) {
        BillingEntity billingEntity = billingRepository.findById(billingId).orElse(null);
        if (billingEntity != null) {
            return billingEntity;
        } else {
            return null; //TODO Handle not found case appropriately
        }
    }

    @Override
    public BillingEntity updateBilling (Long billingId, BillingEntity updatedBilling) {
        BillingEntity billingEntity = billingRepository.findById(billingId).orElse(null);
        if (billingEntity != null) {
            // Update billingEntity with data from updatedBilling
            billingEntity.setRideDistance(updatedBilling.getRideDistance());
            billingEntity.setTotalAmount(updatedBilling.getTotalAmount());
            billingEntity = billingRepository.save(billingEntity);

            return billingEntity;
        } else {
            return null; //TODO Handle not found case appropriately
        }
    }

    @Override
    public List<BillingEntity> getAllBillings () {
        return billingRepository.findAll();
    }

}
