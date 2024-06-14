package me.jincrates.api.order.service;

import me.jincrates.api.order.service.request.OrderPrepareRequest;
import me.jincrates.api.order.service.response.OrderPrepareResponse;

public interface PrepareOrderUseCase {

    OrderPrepareResponse prepareOrder(OrderPrepareRequest request);
}
