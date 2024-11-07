package me.jincrates.domain.model;

import lombok.Builder;
import me.jincrates.domain.enums.OrderStatus;

@Builder
public record Order(
    Long id,
    String code,
    OrderStatus status
) {

}
