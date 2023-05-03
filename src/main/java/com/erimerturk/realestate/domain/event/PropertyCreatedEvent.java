package com.erimerturk.realestate.domain.event;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCreatedEvent {

    private Long id;

    private LocalDateTime date;

    public PropertyCreatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }
}
