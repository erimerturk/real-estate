package com.erimerturk.realestate.infra.adapters.out.eventpublisher;

import com.erimerturk.realestate.application.ports.out.PropertyEventPublisher;
import com.erimerturk.realestate.domain.event.PropertyCreatedEvent;
import com.erimerturk.realestate.domain.event.PropertyUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class PropertyEventPublisherAdapter implements PropertyEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishPropertyCreatedEvent(PropertyCreatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void publishPropertyUpdatedEvent(PropertyUpdatedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}