package ru.practicum.shareit.booking.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.booking.model.State;
import ru.practicum.shareit.constants.Constants;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.repository.UserRepository;

@Data
@Component
@AllArgsConstructor
public class UserAvailableChecker extends EntryAccessor {

    private UserRepository userRepository;

    @Override
    protected void check(Long bookerId, State state) {
        getUserRepository().findById(bookerId).orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND));
    }
}