package ru.practicum.shareit.booking.service;

import org.springframework.stereotype.Component;
import ru.practicum.shareit.constants.Constants;
import ru.practicum.shareit.exception.BadRequestException;

@Component
public class ParamsFromSizeChecker extends EntryAccessor {
    @Override
    protected void check(InputRequest inputRequest) {
        if (inputRequest.getFrom() < 0 || inputRequest.getSize() < 0) {
            throw new BadRequestException(Constants.NEGATIVE_VALUE);
        }
    }
}