package me.jincrates.pf.application.usecase;

import java.util.Optional;
import me.jincrates.pf.application.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.application.usecase.dto.OrderResponse;

public interface OrderUseCase {

    OrderResponse saveOrder(CreateOrderCommand command);

    OrderResponse getOrderByCode(String orderCode);

    Optional<OrderResponse> findOrderByCode(String orderCode);
}
