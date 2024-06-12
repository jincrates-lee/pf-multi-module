package me.jincrates.domain.core.entity;

public record OrderRequest(
    Long id,
    Long orderId,
    String mobileOsCode,
    String paymentMethodCode
) {

}
