package ru.practicum.shareit.item.service;


import org.mapstruct.*;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.item.dto.CommentDto;
import ru.practicum.shareit.item.dto.CommentDtoResponse;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.ItemDtoResponse;
import ru.practicum.shareit.item.model.Comment;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toItem(ItemDto itemDto);

    ItemDto toItemDto(Item item);

    ItemDtoResponse toItemDtoResponse(Item item, List<Comment> comments);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateItemFromItemDto(ItemDto itemDto, @MappingTarget Item item);

    @Mapping(ignore = true, target = "id")
    Comment toComment(CommentDto commentDto, Item item, User author, LocalDateTime created);

    @Mapping(source = "author.name", target = "authorName")
    CommentDtoResponse commentToCommentDtoResponse(Comment comment);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "itemDtoResponse.id", target = "id")
    @Mapping(source = "next", target = "nextBooking")
    @Mapping(source = "last", target = "lastBooking")
    ItemDtoResponse updateItemDtoResponseWithBookings(ItemDtoResponse itemDtoResponse, Booking next, Booking last);

    @Mapping(source = "booker.id", target = "bookerId")
    ItemDtoResponse.BookingDto bookingToBookingDto(Booking booking);
}