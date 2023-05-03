package com.erimerturk.realestate.domain.event;

import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyUpdatedEvent {

    private Long id;

    private LocalDateTime date;

    public PropertyUpdatedEvent(Long id) {
        this.id = id;
        this.date = LocalDateTime.now();
    }
}
