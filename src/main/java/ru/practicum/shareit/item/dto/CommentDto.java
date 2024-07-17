package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class CommentDto {

    @NotBlank
    @Length(max = 255)
    private String text;
}