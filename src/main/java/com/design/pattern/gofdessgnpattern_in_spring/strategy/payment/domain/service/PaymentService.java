package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.handler.PaymentStrategyGetter;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
   private final PaymentStrategyGetter paymentStrategyGetter;

   public PaymentService(PaymentStrategyGetter paymentStrategyGetter) {
      this.paymentStrategyGetter = paymentStrategyGetter;
   }

   public void processPayment(Payment payment) {
      // 전략을 가져와서 해당 전략을 실행한다. (전략 패턴)
        paymentStrategyGetter
                .getStrategy(payment.getPaymentType())
                .processPayment(payment);
   }
}
