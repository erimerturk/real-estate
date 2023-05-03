package com.erimerturk.realestate.infra.adapters.out.persistence.repository;

import com.erimerturk.realestate.infra.adapters.out.persistence.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

}