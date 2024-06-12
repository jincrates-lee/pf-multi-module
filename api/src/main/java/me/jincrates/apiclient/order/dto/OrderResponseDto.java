package me.jincrates.apiclient.order.dto;

import me.jincrates.domain.core.enumtype.OrderStatus;

public record OrderResponseDto(
    Long id,
    OrderStatus orderStatus,
    Long paymentId,
    String paymentMethodCode,
    String transKey
) {

}
