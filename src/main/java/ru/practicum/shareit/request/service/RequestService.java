package ru.practicum.shareit.request.service;


import ru.practicum.shareit.request.dto.ItemRequestDto;
import ru.practicum.shareit.request.dto.ItemRequestDtoResponse;

import java.util.List;

public interface RequestService {
    ItemRequestDtoResponse saveRequest(Long userId, ItemRequestDto itemRequestDto);

    List<ItemRequestDtoResponse> getAllByRequesterId(Long ownerId);

    List<ItemRequestDtoResponse> getAllRequests(Long userId, Integer from, Integer size);

    ItemRequestDtoResponse getRequestById(Long userId, Long requestId);
}