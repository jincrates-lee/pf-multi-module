package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.Order;

public interface OrderWriter {

    Order save(Order order);

    Order update(Order order);
}
