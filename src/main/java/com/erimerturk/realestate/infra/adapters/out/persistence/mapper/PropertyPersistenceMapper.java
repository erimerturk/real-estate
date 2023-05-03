package com.erimerturk.realestate.infra.adapters.out.persistence.mapper;

import com.erimerturk.realestate.domain.model.Property;
import com.erimerturk.realestate.infra.adapters.out.persistence.entity.PropertyEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PropertyPersistenceMapper {

    PropertyEntity toEntity(Property property);

    Property toModel(PropertyEntity entity);


}
