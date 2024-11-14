package me.jincrates.pf.core.port.messagequeue;

import me.jincrates.pf.core.domain.event.DomainEvent;

public interface MessagePublishPort {

    void publish(DomainEvent event);
}
