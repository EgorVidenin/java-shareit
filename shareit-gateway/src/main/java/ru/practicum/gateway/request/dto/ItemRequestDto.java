package ru.practicum.gateway.request.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class ItemRequestDto {

    @NotNull
    @Size(min = 1, max = 250, message = "Description must be between 1 and 250 characters")
    private String description;
}