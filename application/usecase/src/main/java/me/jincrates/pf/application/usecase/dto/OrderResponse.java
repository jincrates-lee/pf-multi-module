package me.jincrates.pf.application.usecase.dto;

import lombok.Builder;
import me.jincrates.domain.enums.OrderStatus;

@Builder
public record OrderResponse(
    String code,
    OrderStatus status
) {

}
