package me.jincrates.api.order.service;

import me.jincrates.api.order.service.request.OrderCompleteRequest;
import me.jincrates.api.order.service.response.OrderResponse;

public interface CompleteOrderUseCase {

    OrderResponse completeOrder(OrderCompleteRequest request);
}
