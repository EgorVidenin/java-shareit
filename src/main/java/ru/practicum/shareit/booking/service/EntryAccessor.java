package ru.practicum.shareit.booking.service;

import ru.practicum.shareit.booking.model.State;

import java.util.Objects;


public abstract class EntryAccessor {
    private EntryAccessor next;

    protected void checkNext(Long bookerId, State state) {
        if (Objects.nonNull(next)) {
            next.check(bookerId, state);
        }
    }

    protected void bind(EntryAccessor next) {
        this.next = next;
    }

    protected abstract void check(Long bookerId, State state);
}