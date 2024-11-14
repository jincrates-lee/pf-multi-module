package me.jincrates.pf.core.usecase.handler;

import lombok.extern.slf4j.Slf4j;
import me.jincrates.pf.core.domain.event.DomainEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(DomainEvent event) {
        this.applicationEventPublisher.publishEvent(event);
        log.info(
            "{} is published!",
            event.getClass().getSimpleName()
        );
    }
}
