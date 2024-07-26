package ru.practicum.shareit.user.dto;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;
}