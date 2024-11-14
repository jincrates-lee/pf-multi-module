package me.jincrates.pf.core.usecase;

import me.jincrates.pf.core.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.core.usecase.dto.OrderResponse;

public interface OrderUseCase {

    OrderResponse saveOrder(CreateOrderCommand command);

    OrderResponse getOrderByCode(String orderCode);
}
