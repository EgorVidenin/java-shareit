package ru.practicum.shareit.booking.dto;

import lombok.AccessLevel;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.booking.model.Status;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;


/**
 * TODO Sprint add-bookings.
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(chain = true)
public class BookingDto {
    Long id;
    LocalDateTime start;
    LocalDateTime end;
    Item item;
    User booker;
    Status status;
}