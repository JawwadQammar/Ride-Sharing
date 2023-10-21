package com.ridesharing.billingmanagement.service;

import com.ridesharing.billingmanagement.entity.BillingEntity;

import java.util.List;

public interface BillingService {
    BillingEntity createBilling (BillingEntity billingEntity);

    BillingEntity getBillingById (Long billingId);

    BillingEntity updateBilling (Long billingId, BillingEntity updatedBilling);

    List<BillingEntity> getAllBillings ();
}
