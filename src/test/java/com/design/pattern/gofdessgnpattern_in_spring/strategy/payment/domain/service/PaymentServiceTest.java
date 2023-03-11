package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private PaymentService paymentService;
    @Test
    @DisplayName("Payment Strategy Bean 테스트")
    void processPayment() {
        // stripe bean
        paymentService.processPayment(new Payment(Payment.PaymentType.STRIPE , UUID.randomUUID().toString(), "PROGRESS"));
        // paypal bean
        paymentService.processPayment(new Payment(Payment.PaymentType.PAYPAL , UUID.randomUUID().toString(), "PROGRESS"));
    }
}