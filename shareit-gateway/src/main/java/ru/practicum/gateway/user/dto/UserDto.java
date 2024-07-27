package ru.practicum.gateway.user.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class UserDto {

    private Long id;

    @NotBlank(groups = CreateUser.class)
    private String name;

    @Email(groups = {CreateUser.class, UpdateUser.class})
    @NotBlank(groups = {CreateUser.class, UpdateUser.class})
    private String email;
}