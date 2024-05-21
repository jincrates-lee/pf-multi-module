package me.jincrates.domain.core.dto;

import lombok.Getter;
import me.jincrates.domain.core.valueobject.OrderStatus;

public record Order(
    Long id,
    OrderStatus status,
    Long paymentId
) {
}
