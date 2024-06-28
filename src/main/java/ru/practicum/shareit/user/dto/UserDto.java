package ru.practicum.shareit.user.dto;

import lombok.Data;
import ru.practicum.shareit.user.model.NewUser;
import ru.practicum.shareit.user.model.UpdateUser;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    private Long id;
    @NotNull(groups = NewUser.class)
    private String name;
    @Email(groups = {NewUser.class, UpdateUser.class})
    @NotNull(groups = NewUser.class)
    private String email;
}