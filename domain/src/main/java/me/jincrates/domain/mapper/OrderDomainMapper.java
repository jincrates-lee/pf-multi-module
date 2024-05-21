package me.jincrates.domain.mapper;

import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.OrderRequest;
import me.jincrates.domain.core.entity.OrderEntity;
import me.jincrates.domain.core.entity.OrderRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderDomainMapper {

    public OrderEntity toEntity(Order domain) {
        return OrderEntity.builder()
            .id(domain.id())
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
