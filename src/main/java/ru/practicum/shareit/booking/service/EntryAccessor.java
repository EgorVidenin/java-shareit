package ru.practicum.shareit.booking.service;

import java.util.Objects;


public abstract class EntryAccessor {
    private EntryAccessor next;

    protected void checkNext(InputRequest inputRequest) {
        if (Objects.nonNull(next)) {
            next.check(inputRequest);
        }
    }

    protected void bind(EntryAccessor next) {
        this.next = next;
    }

    protected abstract void check(InputRequest inputRequest);
}