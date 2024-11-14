package me.jincrates.pf.core.usecase.dto;

import java.util.List;
import lombok.Builder;
import me.jincrates.pf.core.domain.enums.OrderStatus;

@Builder
public record OrderResponse(
    String code,
    Long userId,
    OrderStatus status,
    List<OrderProductResponse> products
) {

    @Builder
    public record OrderProductResponse(
        Long id,
        String orderCode,
        Long productId,
        int quantity
    ) {

    }
}
