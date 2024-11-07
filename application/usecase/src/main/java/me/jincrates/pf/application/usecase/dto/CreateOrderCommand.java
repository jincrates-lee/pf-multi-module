package me.jincrates.pf.application.usecase.dto;

import me.jincrates.domain.enums.OrderStatus;

public record CreateOrderCommand(
    OrderStatus status
) {

}
