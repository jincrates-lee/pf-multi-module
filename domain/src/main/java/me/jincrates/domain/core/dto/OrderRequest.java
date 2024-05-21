package me.jincrates.domain.core.dto;

public record OrderRequest(
    Long id,
    Long orderId,
    String mobileOsCode,
    String paymentMethodCode
) {

}
