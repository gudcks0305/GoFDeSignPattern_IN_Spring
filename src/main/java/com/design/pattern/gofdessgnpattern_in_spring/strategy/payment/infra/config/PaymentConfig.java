package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.config;

import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.PaymentService;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain.service.strategy.PaymentProcessor;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.service.strategy.PaypalPaymentProcessor;
import com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.infra.service.strategy.StripePaymentProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean(name = "paypalPaymentProcessor")
    //@ConditionalOnProperty(name = "payment.gateway", havingValue = "paypal")
    public PaymentProcessor payPalPaymentProcessor() {
        return new PaypalPaymentProcessor();
    }

    @Bean(name = "stripePaymentProcessor")
    //@ConditionalOnProperty(name = "payment.gateway", havingValue = "stripe")
    public PaymentProcessor stripePaymentProcessor() {
        return new StripePaymentProcessor();
    }
}
