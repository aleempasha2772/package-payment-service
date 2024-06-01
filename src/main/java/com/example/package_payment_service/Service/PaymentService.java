package com.example.package_payment_service.Service;

import com.example.package_payment_service.Entity.TransactionDetails;
import com.example.package_payment_service.Repository.TransactionDetailsRepository;
import com.example.package_payment_service.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    public long doPayment(PaymentRequest paymentRequest) {

        TransactionDetails transactionDetails
                = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getPrice())
                .build();

        transactionDetailsRepository.save(transactionDetails);


        return transactionDetails.getId();
    }


}
