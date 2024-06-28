package ru.practicum.shareit.booking.dto;

import lombok.Data;
import ru.practicum.shareit.booking.model.Status;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
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