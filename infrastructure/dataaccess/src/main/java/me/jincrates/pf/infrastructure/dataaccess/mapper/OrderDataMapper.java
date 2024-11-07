package me.jincrates.pf.infrastructure.dataaccess.mapper;

import me.jincrates.domain.model.Order;
import me.jincrates.pf.infrastructure.dataaccess.entity.OrderEntity;

public class OrderDataMapper {

    public static OrderEntity toEntity(Order domain) {
        return OrderEntity.builder()
            .id(domain.id())
            .code(domain.code())
            .status(domain.status())
            .build();
    }

    public static Order toDomain(OrderEntity entity) {
        return Order.builder()
            .id(entity.getId())
            .code(entity.getCode())
            .status(entity.getStatus())
            .build();
    }
}
