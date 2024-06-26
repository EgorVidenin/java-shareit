package ru.practicum.shareit.item.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.user.model.User;

/**
 * TODO Sprint add-controllers.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
@Data
public class Item {
    long id;
    String name;
    String description;
    Boolean available;
    User owner;
    String request;
}