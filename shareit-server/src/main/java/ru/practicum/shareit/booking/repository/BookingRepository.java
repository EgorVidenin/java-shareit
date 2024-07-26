package ru.practicum.shareit.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.booking.model.Status;
import ru.practicum.shareit.item.model.Item;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findALLByItem(Item item);

    List<Booking> findAllByBookerId(long bookerId, Pageable page);

    List<Booking> findAllByBookerIdAndStartIsAfter(Long bookerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByBookerIdAndEndIsBefore(Long bookerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByItemOwnerId(long ownerId, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStartIsBeforeAndEndIsAfter(long ownerId, LocalDateTime before, LocalDateTime after, Pageable page);

    List<Booking> findAllByBookerIdAndStartIsBeforeAndEndIsAfter(long bookerId, LocalDateTime before, LocalDateTime after, Pageable page);

    List<Booking> findALLByItemOwnerIdAndStartIsAfter(Long ownerId, LocalDateTime date, Pageable page);

    List<Booking> findALLByItemOwnerIdAndEndIsBefore(Long ownerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByBookerIdAndStatus(Long bookerId, Status status, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStatus(Long ownerId, Status status, Pageable page);

    List<Booking> findAllByItemIdAndBookerIdAndEndIsBefore(Long itemId, Long bookerId, LocalDateTime localDateTime);
}