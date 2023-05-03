package com.erimerturk.realestate.infra.adapters.config;

import com.erimerturk.realestate.domain.service.PropertyService;
import com.erimerturk.realestate.infra.adapters.out.eventpublisher.PropertyEventPublisherAdapter;
import com.erimerturk.realestate.infra.adapters.out.persistence.PropertyPersistenceAdapter;
import com.erimerturk.realestate.infra.adapters.out.persistence.mapper.PropertyPersistenceMapper;
import com.erimerturk.realestate.infra.adapters.out.persistence.repository.PropertyRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PropertyPersistenceAdapter propertyPersistenceAdapter(PropertyRepository propertyRepository, PropertyPersistenceMapper propertyPersistenceMapper) {
        return new PropertyPersistenceAdapter(propertyRepository, propertyPersistenceMapper);
    }

    @Bean
    public PropertyEventPublisherAdapter propertyEventPublisherAdapter(ApplicationEventPublisher applicationEventPublisher) {
        return new PropertyEventPublisherAdapter(applicationEventPublisher);
    }

    @Bean
    public PropertyService propertyService(PropertyPersistenceAdapter propertyPersistenceAdapter, PropertyEventPublisherAdapter propertyEventPublisherAdapter) {
        return new PropertyService(propertyPersistenceAdapter, propertyEventPublisherAdapter);
    }
    
}
