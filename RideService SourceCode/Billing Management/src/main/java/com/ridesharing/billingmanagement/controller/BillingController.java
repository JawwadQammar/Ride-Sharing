package com.ridesharing.billingmanagement.controller;

import com.ridesharing.billingmanagement.entity.BillingEntity;
import com.ridesharing.billingmanagement.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingController {
    private final BillingService billingService;

    @Autowired
    public BillingController (BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public BillingEntity createBilling (@RequestBody BillingEntity billingEntity) {
        return billingService.createBilling(billingEntity);
    }

    @GetMapping("/{billingId}")
    public BillingEntity getBilling (@PathVariable Long billingId) {
        return billingService.getBillingById(billingId);
    }

    @PutMapping("/{billingId}")
    public BillingEntity updateBilling (@PathVariable Long billingId, @RequestBody BillingEntity updatedBilling) {
        return billingService.updateBilling(billingId, updatedBilling);
    }

    @GetMapping
    public List<BillingEntity> getAllBillings () {
        return billingService.getAllBillings();
    }
}
