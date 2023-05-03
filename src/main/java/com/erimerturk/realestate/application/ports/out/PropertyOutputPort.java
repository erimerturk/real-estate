package com.erimerturk.realestate.application.ports.out;

import com.erimerturk.realestate.domain.model.Property;

import java.util.Optional;

public interface PropertyOutputPort {
    Property save(Property property);
    Optional<Property> getById(Long id);

}
