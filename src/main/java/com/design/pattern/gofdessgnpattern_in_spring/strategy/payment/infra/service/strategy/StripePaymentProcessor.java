package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.service.strategy;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.strategy.PaymentProcessor;
import org.springframework.stereotype.Service;

public class StripePaymentProcessor implements PaymentProcessor {
   @Override
   public void processPayment(Payment payment) {
         System.out.println("Stripe payment processor");
   }
}
