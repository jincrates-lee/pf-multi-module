package me.jincrates.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.OrderRequest;
import me.jincrates.domain.core.entity.OrderEntity;
import me.jincrates.domain.core.entity.OrderRequestEntity;
import me.jincrates.domain.core.repository.OrderRepository;
import me.jincrates.domain.core.repository.OrderRequestRepository;
import me.jincrates.domain.core.valueobject.OrderStatus;
import me.jincrates.domain.exception.DomainException;
import me.jincrates.domain.mapper.OrderDomainMapper;
import me.jincrates.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class OrderDomainServiceImpl implements OrderDomainService {
    private final OrderDomainMapper orderMapper;
    private final OrderRequestRepository orderRequestRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderRequest saveOrderRequest(OrderRequest orderRequest) {
        OrderRequestEntity entity = orderMapper.toEntity(orderRequest);
        return orderMapper.toDomain(orderRequestRepository.save(entity));
    }

    @Override
    public OrderRequest findOrderRequestById(Long id) {
        OrderRequestEntity entity = orderRequestRepository.findById(id)
            .orElseThrow(() -> {
                log.info("주문 요청이 존재하지 않습니다. id: {}", id);
                return new DomainException("주문 요청이 존재하지 않습니다.");
            });
        return orderMapper.toDomain(entity);
    }

    @Override
    public OrderRequest findOrderRequestByOrderId(Long orderId) {
        OrderRequestEntity entity = orderRequestRepository.findByOrderId(orderId)
            .orElseThrow(() -> {
                log.info("주문 요청이 존재하지 않습니다. orderId: {}", orderId);
                return new DomainException("주문 요청이 존재하지 않습니다.");
            });
        return orderMapper.toDomain(entity);
    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        OrderEntity entity = orderMapper.toEntity(order);
        return orderMapper.toDomain(orderRepository.save(entity));
    }

    @Override
    public Order findOrderById(Long id) {
        OrderEntity entity = orderRepository.findById(id)
            .orElseThrow(() -> {
                log.info("주문이 존재하지 않습니다. id: {}", id);
                return new DomainException("주문이 존재하지 않습니다.");
            });
        return orderMapper.toDomain(entity);
    }

    @Override
    @Transactional
    public Order updateOrderStatus(Long id, OrderStatus status) {
        OrderEntity entity = orderRepository.findById(id)
            .orElseThrow(() -> {
                log.info("주문이 존재하지 않습니다. id: {}", id);
                return new DomainException("주문이 존재하지 않습니다.");
            });
        entity.updateStatus(status);
        return orderMapper.toDomain(entity);
    }
}
