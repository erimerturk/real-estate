package com.erimerturk.realestate.infra.adapters.in.rest;

import com.erimerturk.realestate.application.ports.in.CreatePropertyUseCase;
import com.erimerturk.realestate.application.ports.in.GetPropertyUseCase;
import com.erimerturk.realestate.application.ports.in.UpdatePropertyUseCase;
import com.erimerturk.realestate.domain.model.Property;
import com.erimerturk.realestate.infra.adapters.in.rest.data.request.PropertyCreateRequest;
import com.erimerturk.realestate.infra.adapters.in.rest.data.request.PropertyUpdateRequest;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyCreateResponse;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyQueryResponse;
import com.erimerturk.realestate.infra.adapters.in.rest.data.response.PropertyUpdateResponse;
import com.erimerturk.realestate.infra.adapters.in.rest.mapper.PropertyRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/property/v1")
@RequiredArgsConstructor
public class PropertyRestAdapter {

    private final CreatePropertyUseCase createPropertyUseCase;
    private final UpdatePropertyUseCase updatePropertyUseCase;

    private final GetPropertyUseCase getPropertyUseCase;

    private final PropertyRestMapper propertyRestMapper;

    @PostMapping(value = "/")
    public ResponseEntity<PropertyCreateResponse> createProperty(@RequestBody @Valid PropertyCreateRequest propertyCreateRequest) {
        Property property = propertyRestMapper.toProperty(propertyCreateRequest);
        property = createPropertyUseCase.create(property);
        return new ResponseEntity<>(propertyRestMapper.toPropertyCreateResponse(property), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PropertyQueryResponse> getProperty(@PathVariable Long id) {
        Property property = getPropertyUseCase.getById(id);
        return new ResponseEntity<>(propertyRestMapper.toPropertyQueryResponse(property), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PropertyUpdateResponse> updateProperty(@PathVariable Long id, @RequestBody @Valid PropertyUpdateRequest propertyUpdateRequest) {
        propertyUpdateRequest.setId(id);
        Property property = propertyRestMapper.toProperty(propertyUpdateRequest);
        property = updatePropertyUseCase.update(property);
        return new ResponseEntity<>(propertyRestMapper.toPropertyUpdateResponse(property), HttpStatus.OK);
    }


}
