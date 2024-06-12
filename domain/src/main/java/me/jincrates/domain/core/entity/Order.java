package me.jincrates.domain.core.entity;

import me.jincrates.domain.core.enumtype.OrderStatus;

public record Order(
    Long id,
    OrderStatus status,
    Long paymentId
) {

}
