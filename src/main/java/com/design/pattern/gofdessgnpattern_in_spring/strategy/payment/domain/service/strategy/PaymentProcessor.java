package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;

public interface PaymentProcessor {
    void processPayment(Payment payment);
}
