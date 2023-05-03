package com.erimerturk.realestate.infra.adapters.in.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCreateResponse {
    private Long id;

    private String name;

    private String description;
}
