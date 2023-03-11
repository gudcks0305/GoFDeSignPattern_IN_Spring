package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.handler;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.global.utils.BeanUtils;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.Payment;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.strategy.PaymentProcessor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyGetter {

    public PaymentProcessor getStrategy(Payment.PaymentType strategy) {
        // bean 이름으로 불러오기
        //
        /*try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("com.design.pattern.gofdessgnpattern_in_spring.strategy.payment");
            return switch (strategy) {
                case PAYPAL -> context.getBean("paypalPaymentProcessor", PaymentProcessor.class);
                case STRIPE -> context.getBean("stripePaymentProcessor", PaymentProcessor.class);
                default -> throw new IllegalArgumentException("Not supported payment type");
            };
        }*/
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
