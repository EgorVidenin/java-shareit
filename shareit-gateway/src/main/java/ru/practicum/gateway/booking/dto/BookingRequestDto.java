package ru.practicum.gateway.booking.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BookingRequestDto {

    @NotNull
    private Long itemId;

    @NotNull
    @FutureOrPresent
    private LocalDateTime start;

    @NotNull
    @Future(message = "End date must be in the future")
    private LocalDateTime end;
}