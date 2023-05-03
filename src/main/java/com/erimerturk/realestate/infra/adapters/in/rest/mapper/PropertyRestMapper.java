package com.erimerturk.realestate.infra.adapters.in.rest.mapper;

import com.erimerturk.realestate.domain.model.Property;
import com.erimerturk.realestate.infra.adapters.in.rest.data.request.PropertyCreateRequest;
import com.erimerturk.realestate.infra.adapters.in.rest.data.request.PropertyUpdateRequest;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyCreateResponse;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyQueryResponse;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyUpdateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PropertyRestMapper {

    Property toProperty(PropertyCreateRequest request);
    Property toProperty(PropertyUpdateRequest request);

    PropertyCreateResponse toPropertyCreateResponse(Property property);
    PropertyUpdateResponse toPropertyUpdateResponse(Property property);

    PropertyQueryResponse toPropertyQueryResponse(Property property);

}
