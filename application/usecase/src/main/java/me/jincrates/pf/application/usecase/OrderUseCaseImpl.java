package me.jincrates.pf.application.usecase;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.jincrates.common.annotation.UseCase;
import me.jincrates.domain.model.Order;
import me.jincrates.pf.application.port.OrderDataPort;
import me.jincrates.pf.application.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.application.usecase.dto.OrderResponse;
import me.jincrates.pf.application.usecase.mapper.OrderApplicationMapper;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
class OrderUseCaseImpl implements OrderUseCase {

    private final OrderDataPort orderDataPort;

    @Override
    @Transactional
    public OrderResponse saveOrder(CreateOrderCommand command) {
        Order savedOrder = orderDataPort.saveOrder(OrderApplicationMapper.toDomain(command));
        return OrderApplicationMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse getOrderByCode(String orderCode) {
        Order order = orderDataPort.getOrderByCode(orderCode);
        return OrderApplicationMapper.toResponse(order);
    }

    @Override
    public Optional<OrderResponse> findOrderByCode(String orderCode) {
        return orderDataPort.findOrderByCode(orderCode)
            .map(OrderApplicationMapper::toResponse);
    }
}
