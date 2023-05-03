package com.erimerturk.realestate.application.ports.in;

import com.erimerturk.realestate.domain.model.Property;

public interface UpdatePropertyUseCase {
    Property update(Property property);
}
