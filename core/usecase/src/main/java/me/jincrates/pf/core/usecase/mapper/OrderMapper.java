package me.jincrates.pf.core.usecase.mapper;

import java.util.List;
import me.jincrates.pf.common.utils.IdGenerator;
import me.jincrates.pf.core.domain.enums.OrderStatus;
import me.jincrates.pf.core.domain.model.Order;
import me.jincrates.pf.core.domain.model.OrderProduct;
import me.jincrates.pf.core.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.core.usecase.dto.CreateOrderCommand.CreateOrderProductCommand;
import me.jincrates.pf.core.usecase.dto.OrderResponse;
import me.jincrates.pf.core.usecase.dto.OrderResponse.OrderProductResponse;

public class OrderMapper {

    public static Order toDomain(CreateOrderCommand command) {
        String orderCode = IdGenerator.generateRandomId();
        return Order.builder()
            .code(orderCode)
            .userId(command.userId())
            .status(OrderStatus.REQUESTED)
            .products(toDomain(
                command.products(),
                orderCode
            ))
            .build();
    }

    private static List<OrderProduct> toDomain(
        List<CreateOrderProductCommand> commands,
        String orderCode
    ) {
        return commands.stream()
            .map(it -> OrderProduct.builder()
                .orderCode(orderCode)
                .productId(it.productId())
                .quantity(it.quantity())
                .build()
            )
            .toList();
    }

    public static OrderResponse toResponse(Order domain) {
        return OrderResponse.builder()
            .code(domain.code())
            .userId(domain.userId())
            .status(domain.status())
            .products(toResponse(domain.products()))
            .build();
    }

    private static List<OrderProductResponse> toResponse(List<OrderProduct> products) {
        return products.stream()
            .map(product -> OrderProductResponse.builder()
                .id(product.id())
                .orderCode(product.orderCode())
                .productId(product.productId())
                .quantity(product.quantity())
                .build())
            .toList();
    }
}
