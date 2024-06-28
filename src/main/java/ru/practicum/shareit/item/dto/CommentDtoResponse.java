package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
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