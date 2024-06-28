package ru.practicum.shareit.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemDtoResponse {

    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private BookingDto lastBooking;
    private BookingDto nextBooking;
    private List<CommentDtoResponse> comments;

    @AllArgsConstructor
    @Data
    public static class BookingDto {
        @NotNull
        private Long id;
        @NotNull
        private Long bookerId;
    }
}