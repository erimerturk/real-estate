package com.erimerturk.realestate.domain.service;

import com.erimerturk.realestate.application.ports.in.CreatePropertyUseCase;
import com.erimerturk.realestate.application.ports.in.GetPropertyUseCase;
import com.erimerturk.realestate.application.ports.in.UpdatePropertyUseCase;
import com.erimerturk.realestate.application.ports.out.PropertyEventPublisher;
import com.erimerturk.realestate.application.ports.out.PropertyOutputPort;
import com.erimerturk.realestate.domain.event.PropertyCreatedEvent;
import com.erimerturk.realestate.domain.event.PropertyUpdatedEvent;
import com.erimerturk.realestate.domain.exception.PropertyNotFound;
import com.erimerturk.realestate.domain.model.Property;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PropertyService implements CreatePropertyUseCase, GetPropertyUseCase, UpdatePropertyUseCase {
    private final PropertyOutputPort propertyOutputPort;
    private final PropertyEventPublisher propertyEventPublisher;

    @Override
    public Property create(Property property) {
        Property persisted = propertyOutputPort.save(property);
        propertyEventPublisher.publishPropertyCreatedEvent(new PropertyCreatedEvent(persisted.getId()));
        return persisted;
    }

    @Override
    public Property getById(Long id) {
        return propertyOutputPort.getById(id).orElseThrow(() -> new PropertyNotFound("Not found by id: " + id));
    }

    @Override
    public Property update(Property property) {
        var fromDB = getById(property.getId());
        Property persisted = propertyOutputPort.save(fromDB.update(property));
        propertyEventPublisher.publishPropertyUpdatedEvent(new PropertyUpdatedEvent(persisted.getId()));
        return persisted;
    }
}
