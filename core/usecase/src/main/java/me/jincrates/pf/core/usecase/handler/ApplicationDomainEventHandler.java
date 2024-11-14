package me.jincrates.pf.core.usecase.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jincrates.pf.core.domain.event.DomainEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationDomainEventHandler {

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handle(DomainEvent event) {
//        messagePublishPort.publish(
//            TopicConstant.ORDER_REQUESTED,
//            event.order().code(),
//            event
//        );
//
//        log.info(
//            "OrderRequested event published: {}",
//            event.order().code()
//        );
    }
}
