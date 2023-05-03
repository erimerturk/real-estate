package com.erimerturk.realestate.application.ports.out;

import com.erimerturk.realestate.domain.event.PropertyCreatedEvent;
import com.erimerturk.realestate.domain.event.PropertyUpdatedEvent;

public interface PropertyEventPublisher {

    void publishPropertyCreatedEvent(PropertyCreatedEvent event);

    void publishPropertyUpdatedEvent(PropertyUpdatedEvent event);

}
