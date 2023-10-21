package com.ridesharing.billingmanagement.repository;

import com.ridesharing.billingmanagement.entity.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<BillingEntity, Long> {
}
