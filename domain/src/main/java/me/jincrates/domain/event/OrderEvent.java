package me.jincrates.domain.event;

import java.time.LocalDateTime;
import lombok.Builder;

public sealed interface OrderEvent extends DomainEvent {

    @Builder
    record OrderRequested(
        String orderCode,
        LocalDateTime issuedAt
    ) implements OrderEvent {

    }

    @Builder
    record OrderCompleted(
        String orderCode,
        LocalDateTime issuedAt
    ) implements OrderEvent {

    }

    @Builder
    record OrderCancelled(
        String orderCode,
        LocalDateTime issuedAt
    ) implements OrderEvent {

    }
}
