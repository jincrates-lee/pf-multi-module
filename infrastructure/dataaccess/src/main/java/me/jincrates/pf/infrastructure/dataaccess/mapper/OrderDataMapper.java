package me.jincrates.pf.infrastructure.dataaccess.mapper;

import java.util.List;
import me.jincrates.pf.core.domain.model.Order;
import me.jincrates.pf.core.domain.model.OrderProduct;
import me.jincrates.pf.infrastructure.dataaccess.entity.OrderEntity;
import me.jincrates.pf.infrastructure.dataaccess.entity.OrderProductEntity;

public class OrderDataMapper {

    public static OrderEntity toEntity(Order domain) {
        OrderEntity order = OrderEntity.builder()
            .id(domain.id())
            .code(domain.code())
            .userId(domain.userId())
            .status(domain.status())
            .build();

        for (OrderProduct product : domain.products()) {
            order.addProduct(
                OrderProductEntity.builder()
                    .productId(product.productId())
                    .quantity(product.quantity())
                    .build()
            );
        }

        return order;
    }

    public static Order toDomain(OrderEntity entity) {
        return Order.builder()
            .id(entity.getId())
            .code(entity.getCode())
            .userId(entity.getUserId())
            .status(entity.getStatus())
            .products(toDomain(
                entity.getProducts(),
                entity.getCode()
            ))
            .build();
    }

    private static List<OrderProduct> toDomain(
        List<OrderProductEntity> products,
        String orderCode
    ) {
        return products.stream()
            .map(product -> OrderProduct.builder()
                .id(product.getId())
                .productId(product.getProductId())
                .quantity(product.getQuantity())
                .orderCode(orderCode)
                .build())
            .toList();
    }
}
