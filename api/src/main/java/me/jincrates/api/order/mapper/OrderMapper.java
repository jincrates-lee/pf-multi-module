package me.jincrates.api.order.mapper;

import me.jincrates.api.order.service.request.OrderPrepareRequest;
import me.jincrates.api.order.service.response.OrderPrepareResponse;
import me.jincrates.common.annotation.Mapper;
import me.jincrates.domain.core.entity.OrderRequest;

@Mapper
public class OrderMapper {

    public OrderRequest toDomain(OrderPrepareRequest dto, Long orderId) {
        return new OrderRequest(
            null,
            orderId,
            dto.mobileOsCode(),
            dto.paymentMethodCode()
        );
    }

    public OrderPrepareResponse toResponse(OrderRequest domain) {
        return new OrderPrepareResponse(
            domain.id(),
            domain.orderId(),
            domain.mobileOsCode(),
            domain.paymentMethodCode()
        );
    }
}
