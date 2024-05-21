package me.jincrates.apiclient.order.dto;

import me.jincrates.domain.core.valueobject.OrderStatus;

public record OrderResponseDto(
    Long id,
    OrderStatus orderStatus,
    Long paymentId,
    String paymentMethodCode,
    String transKey
) {

}
