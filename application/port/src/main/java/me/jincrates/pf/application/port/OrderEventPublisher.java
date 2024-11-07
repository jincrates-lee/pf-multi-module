package me.jincrates.pf.application.port;

import me.jincrates.domain.event.OrderEvent;

public interface OrderEventPublisher {

    void publish(OrderEvent event);
}
