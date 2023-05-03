package com.erimerturk.realestate.infra.adapters.in.rest.data.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCreateRequest {
    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Description may not be empty")
    private String description;

}
