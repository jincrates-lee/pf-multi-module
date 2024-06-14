package me.jincrates.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jincrates.domain.core.entity.Order;
import me.jincrates.domain.core.entity.OrderRequest;
import me.jincrates.domain.persistence.OrderReader;
import me.jincrates.domain.persistence.OrderWriter;
import me.jincrates.infrastructure.persistence.entity.OrderRequestEntity;
import me.jincrates.infrastructure.persistence.mapper.OrderPersistenceMapper;
import me.jincrates.infrastructure.persistence.repository.OrderJpaRepository;
import me.jincrates.infrastructure.persistence.repository.OrderRequestJpaRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class OrderRepository implements OrderReader, OrderWriter {

    private final OrderPersistenceMapper mapper;
    private final OrderJpaRepository orderRepository;
    private final OrderRequestJpaRepository orderRequestRepository;

    @Override
    public Order findById(Long orderId) {
        return null;
    }

    @Override
    public Order persist(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public OrderRequest persist(OrderRequest orderRequest) {
        OrderRequestEntity entity = mapper.toEntity(orderRequest);
        return mapper.toDomain(orderRequestRepository.save(entity));
    }
}
