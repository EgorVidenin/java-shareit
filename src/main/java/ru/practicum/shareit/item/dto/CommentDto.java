package ru.practicum.shareit.item.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class CommentDto {

    @NotBlank
    @Length(max = 255)
    private String text;
}