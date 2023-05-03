package com.erimerturk.realestate.application.ports.in;

import com.erimerturk.realestate.domain.model.Property;

public interface GetPropertyUseCase {

    Property getById(Long id);

}
