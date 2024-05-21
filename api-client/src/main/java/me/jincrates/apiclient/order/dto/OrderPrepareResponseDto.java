package me.jincrates.apiclient.order.dto;

import me.jincrates.domain.core.valueobject.OrderStatus;

public record OrderPrepareResponseDto(
    Long orderId
) {

}
