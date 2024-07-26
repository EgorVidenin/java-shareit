package ru.practicum.gateway.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;

    @NotNull(groups = NewUser.class)
    private String name;

    @Email(groups = {NewUser.class, UpdateUser.class})
    @NotNull(groups = NewUser.class)
    private String email;
}