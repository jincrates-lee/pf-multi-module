package me.jincrates.domain.service;

import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.OrderRequest;
import me.jincrates.domain.core.valueobject.OrderStatus;

public interface OrderDomainService {
    OrderRequest saveOrderRequest(OrderRequest orderRequest);
    OrderRequest findOrderRequestById(Long id);
    OrderRequest findOrderRequestByOrderId(Long orderId);
    Order saveOrder(Order order);
    Order findOrderById(Long id);
    Order updateOrderStatus(Long id, OrderStatus status);
}
