package me.jincrates.pf.pg;

public interface PaymentGateway {
    void prepare(Long orderId, String paymentMethodCode);
    String approve(Long orderId, String paymentMethodCode);
}
