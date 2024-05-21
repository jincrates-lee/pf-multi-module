package me.jincrates.apiclient.order.mapper;

import me.jincrates.apiclient.order.dto.OrderPrepareRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareResponseDto;
import me.jincrates.apiclient.order.dto.OrderResponseDto;
import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.OrderRequest;
import me.jincrates.domain.core.dto.Payment;
import me.jincrates.domain.core.valueobject.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderRequest toDomain(OrderPrepareRequestDto dto, Long orderId) {
        return new OrderRequest(
            null,
            orderId,
            dto.mobileOsCode(),
            dto.paymentMethodCode()
        );
    }

    public OrderPrepareResponseDto toResponse(OrderRequest orderRequest) {
        return new OrderPrepareResponseDto(
            orderRequest.orderId()
        );
    }

    public Order toOrder(Long orderId, OrderStatus orderStatus, Long paymentId) {
        return new Order(
            orderId,
            orderStatus,
            paymentId
        );
    }

    public OrderResponseDto toResponse(Order order, Payment payment) {
        return new OrderResponseDto(
            order.id(),
            order.status(),
            payment.id(),
            payment.paymentMethodCode(),
            payment.transKey()
        );
    }
}
