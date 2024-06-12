package me.jincrates.apiclient.order.dto;

public record OrderPrepareRequestDto(
    String mobileOsCode,
    String paymentMethodCode
) {

}
