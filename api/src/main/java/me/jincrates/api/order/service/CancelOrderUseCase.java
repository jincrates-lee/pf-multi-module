package me.jincrates.api.order.service;

import me.jincrates.api.order.service.request.OrderCancelRequest;

public interface CancelOrderUseCase {

    void cancelOrder(OrderCancelRequest request);
}
