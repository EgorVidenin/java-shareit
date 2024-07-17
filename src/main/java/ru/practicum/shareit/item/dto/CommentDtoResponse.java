package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
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