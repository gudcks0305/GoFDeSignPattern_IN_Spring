package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.handler;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.global.utils.BeanUtils;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.strategy.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyGetter {

    public PaymentProcessor getStrategy(Payment.PaymentType strategy) {
        // Bean 이름을 가져와서 BeanUtils.getBean()을 통해 Bean을 가져온다.
        switch (strategy) {
            case PAYPAL -> {
                return (PaymentProcessor) BeanUtils.getBean("paypalPaymentProcessor");
            }
            case STRIPE -> {
                return (PaymentProcessor) BeanUtils.getBean("stripePaymentProcessor");
            }
            default -> throw new IllegalArgumentException("Not supported payment type");
        }
    }
}
