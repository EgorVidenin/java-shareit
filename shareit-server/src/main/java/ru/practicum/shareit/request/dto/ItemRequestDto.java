package ru.practicum.shareit.request.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemRequestDto {
    private String description;
}