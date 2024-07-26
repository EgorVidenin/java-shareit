package ru.practicum.shareit.request.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.practicum.shareit.item.dto.ItemDto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class ItemRequestDtoResponse {

    @NotNull
    private Long id;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime created;

    @NotNull
    private List<ItemDto> items;
}