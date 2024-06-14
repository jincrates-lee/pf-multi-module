package me.jincrates.api.order.service.response;

public record OrderPrepareResponse(
    Long id,
    Long orderId,
    String mobileOsCode,
    String paymentMethodCode
) {

}
