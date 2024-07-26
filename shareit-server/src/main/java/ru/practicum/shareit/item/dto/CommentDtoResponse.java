package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CommentDtoResponse {

    @NotNull
    private Long id;

    @NotNull
    private String text;

    @NotNull
    private String authorName;

    @NotNull
    private LocalDateTime created;
}