package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.Order;

public interface OrderReader {

    Order findById(Long orderId);
}
