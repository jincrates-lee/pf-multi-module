package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.Order;
import me.jincrates.domain.core.entity.OrderRequest;

public interface OrderWriter {

    Order persist(Order order);

    Order update(Order order);

    OrderRequest persist(OrderRequest orderRequest);
}
