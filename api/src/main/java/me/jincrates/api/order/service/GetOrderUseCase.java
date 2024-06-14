package me.jincrates.api.order.service;

import java.util.List;
import me.jincrates.api.order.service.response.OrderResponse;

public interface GetOrderUseCase {

    List<OrderResponse> getOrders(Long userId);

    OrderResponse getOrder(Long orderId, Long userId);
}
