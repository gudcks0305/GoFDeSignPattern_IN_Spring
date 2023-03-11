package com.design.pattern.gofdessgnpattern_in_spring.strategy.payment.domain;

import lombok.Getter;

@Getter
public class Payment {
    private PaymentType paymentType;
    private String paymentId;
    private String paymentStatus;


    public Payment(PaymentType paymentType, String paymentId, String paymentStatus) {
        this.paymentType = paymentType;
        this.paymentId = paymentId;
        this.paymentStatus = paymentStatus;
    }

    public enum PaymentType {
        CREDIT_CARD("credit_card"),
        PAYPAL("paypal"),
        STRIPE("stripe");
        @Getter
        private final String value;

        PaymentType(String value) {
            this.value = value;
        }
    }

}
