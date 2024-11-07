package me.jincrates.pf.application.usecase.mapper;

import java.util.UUID;
import me.jincrates.domain.model.Order;
import me.jincrates.pf.application.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.application.usecase.dto.OrderResponse;

public class OrderApplicationMapper {

    public static Order toDomain(CreateOrderCommand command) {
        return Order.builder()
            .code("OD-" + UUID.randomUUID())
            .status(command.status())
            .build();
    }

    public static OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
            .code(order.code())
            .status(order.status())
            .build();
    }
}
