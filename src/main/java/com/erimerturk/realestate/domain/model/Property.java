package com.erimerturk.realestate.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private Long id;
    private String name;
    private String description;

    public Property update(Property property) {
        return new Property(property.getId(), property.getName(), property.getDescription());
    }
}
