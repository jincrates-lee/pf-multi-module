package me.jincrates.pf.core.usecase;

import lombok.RequiredArgsConstructor;
import me.jincrates.pf.common.annotation.UseCase;
import me.jincrates.pf.core.domain.model.Order;
import me.jincrates.pf.core.port.dataaccess.OrderDataPort;
import me.jincrates.pf.core.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.core.usecase.dto.OrderResponse;
import me.jincrates.pf.core.usecase.mapper.OrderMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
class OrderUseCaseImpl implements OrderUseCase {

    private final OrderDataPort orderPort;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public OrderResponse saveOrder(CreateOrderCommand command) {
        Order order = OrderMapper.toDomain(command);
        Order savedOrder = orderPort.saveOrder(order);
        //eventPublisher.publishEvent();
        return OrderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse getOrderByCode(String orderCode) {
        Order order = orderPort.getOrderByCode(orderCode);
        return OrderMapper.toResponse(order);
    }
}
