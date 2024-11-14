package me.jincrates.pf.core.port.dataaccess;

import java.util.Optional;
import me.jincrates.pf.core.domain.model.Order;

public interface OrderDataPort {

    Order saveOrder(Order order);

    Order getOrderByCode(String orderCode);

    Optional<Order> findOrderByCode(String orderCode);
}
