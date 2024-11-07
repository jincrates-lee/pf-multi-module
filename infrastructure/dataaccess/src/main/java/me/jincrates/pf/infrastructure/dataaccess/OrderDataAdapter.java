package me.jincrates.pf.infrastructure.dataaccess;

import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import me.jincrates.common.annotation.Adapter;
import me.jincrates.domain.model.Order;
import me.jincrates.pf.application.port.OrderDataPort;
import me.jincrates.pf.infrastructure.dataaccess.entity.OrderEntity;
import me.jincrates.pf.infrastructure.dataaccess.mapper.OrderDataMapper;
import me.jincrates.pf.infrastructure.dataaccess.repository.OrderJpaRepository;

@Adapter
@RequiredArgsConstructor
class OrderDataAdapter implements OrderDataPort {

    private final OrderJpaRepository repository;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity savedEntity = repository.save(OrderDataMapper.toEntity(order));
        return OrderDataMapper.toDomain(savedEntity);
    }

    @Override
    public Order getOrderByCode(String orderCode) {
        return repository.findByCode(orderCode)
            .map(OrderDataMapper::toDomain)
            .orElseThrow(() -> new EntityNotFoundException(
                "Order not found! orderCode: " + orderCode));
    }

    @Override
    public Optional<Order> findOrderByCode(String orderCode) {
        return repository.findByCode(orderCode)
            .map(OrderDataMapper::toDomain);
    }
}
