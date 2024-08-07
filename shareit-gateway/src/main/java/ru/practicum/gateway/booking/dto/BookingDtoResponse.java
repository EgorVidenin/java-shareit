package ru.practicum.gateway.booking.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BookingDtoResponse {

    @NotNull
    private Long id;

    @NotNull
    private LocalDateTime start;

    @NotNull
    private LocalDateTime end;

    @NotNull
    private Status status;

    @NotNull
    private ItemDto item;

    @NotNull
    private UserDto booker;

    @Data
    public static class UserDto {
        @NotNull
        private Long id;
    }

    @Data
    public static class ItemDto {
        @NotNull
        private Long id;
        @NotNull
        private String name;
    }
}