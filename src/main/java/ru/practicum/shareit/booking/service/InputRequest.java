package ru.practicum.shareit.booking.service;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.model.State;

@Component
@Accessors(chain = true)
@Data
public class InputRequest {
    private Long bookerId;
    private State state;
    private Integer from;
    private Integer size;
}