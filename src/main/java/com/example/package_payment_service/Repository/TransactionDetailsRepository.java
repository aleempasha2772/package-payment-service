package com.example.package_payment_service.Repository;

import com.example.package_payment_service.Entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails,Long> {
    TransactionDetails findByOrderId(long orderId);
}
