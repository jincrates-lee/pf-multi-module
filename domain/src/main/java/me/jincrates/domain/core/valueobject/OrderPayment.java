package me.jincrates.domain.core.valueobject;

import me.jincrates.domain.core.entity.Order;
import me.jincrates.domain.core.entity.Payment;

public record OrderPayment(

    Order order,
    Payment payment
) {

}

