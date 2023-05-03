package com.erimerturk.realestate.infra.adapters.out.persistence;

import com.erimerturk.realestate.application.ports.out.PropertyOutputPort;
import com.erimerturk.realestate.domain.model.Property;
import com.erimerturk.realestate.infra.adapters.out.persistence.entity.PropertyEntity;
import com.erimerturk.realestate.infra.adapters.out.persistence.mapper.PropertyPersistenceMapper;
import com.erimerturk.realestate.infra.adapters.out.persistence.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PropertyPersistenceAdapter implements PropertyOutputPort {

    private final PropertyRepository propertyRepository;

    private final PropertyPersistenceMapper propertyPersistenceMapper;

    @Override
    public Property save(Property property) {
        PropertyEntity propertyEntity = propertyPersistenceMapper.toEntity(property);
        propertyEntity = propertyRepository.save(propertyEntity);
        return propertyPersistenceMapper.toModel(propertyEntity);
    }

    @Override
    public Optional<Property> getById(Long id) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(id);

        if (propertyEntity.isEmpty()) {
            return Optional.empty();
        }

        Property property = propertyPersistenceMapper.toModel(propertyEntity.get());
        return Optional.of(property);
    }

}