package me.jincrates.infrastructure.persistence.mapper;

import me.jincrates.domain.core.entity.Order;
import me.jincrates.domain.core.entity.OrderRequest;
import me.jincrates.infrastructure.persistence.entity.OrderEntity;
import me.jincrates.infrastructure.persistence.entity.OrderRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceMapper {

    public OrderEntity toEntity(Order domain) {
        return OrderEntity.builder()
            .id(domain.id())
            .status(domain.status())
            .paymentId(domain.paymentId())
            .build();
    }

    public Order toDomain(OrderEntity entity) {
        return new Order(
            entity.getId(),
            entity.getStatus(),
            entity.getPaymentId()
        );
    }

    public OrderRequestEntity toEntity(OrderRequest domain) {
        return OrderRequestEntity.builder()
            .id(domain.id())
            .orderId(domain.orderId())
            .mobileOsCode(domain.mobileOsCode())
            .paymentMethodCode(domain.paymentMethodCode())
            .build();
    }

    public OrderRequest toDomain(OrderRequestEntity entity) {
        return new OrderRequest(
            entity.getId(),
            entity.getOrderId(),
            entity.getMobileOsCode(),
            entity.getPaymentMethodCode()
        );
    }
}
