package com.erimerturk.realestate.infra.adapters.in.eventlistener;

import com.erimerturk.realestate.domain.event.PropertyCreatedEvent;
import com.erimerturk.realestate.domain.event.PropertyUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PropertyEventListenerAdapter {

    @EventListener
    public void handle(PropertyCreatedEvent event){
        log.info("Property created with id " + event.getId() + " at " + event.getDate());
    }

    @EventListener
    public void handle(PropertyUpdatedEvent event){
        log.info("Property updated with id " + event.getId() + " at " + event.getDate());
    }

}
