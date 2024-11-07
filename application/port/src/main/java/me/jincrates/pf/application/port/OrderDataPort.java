package me.jincrates.pf.application.port;

import java.util.Optional;
import me.jincrates.domain.model.Order;

public interface OrderDataPort {

    Order saveOrder(Order order);

    Order getOrderByCode(String orderCode);

    Optional<Order> findOrderByCode(String orderCode);
}
