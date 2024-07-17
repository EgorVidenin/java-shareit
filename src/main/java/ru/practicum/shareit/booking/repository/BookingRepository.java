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

    List<Booking> findAllByBookerIdOrderByStartDesc(long bookerId, Pageable page);

    List<Booking> findAllByBookerIdAndStartIsAfterOrderByStartDesc(Long bookerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByBookerIdAndEndIsBeforeOrderByStartDesc(Long bookerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByItemOwnerIdOrderByStartDesc(long ownerId, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStartIsBeforeAndEndIsAfterOrderByStartDesc(long ownerId, LocalDateTime before, LocalDateTime after, Pageable page);

    List<Booking> findAllByBookerIdAndStartIsBeforeAndEndIsAfterOrderByStartDesc(long bookerId, LocalDateTime before, LocalDateTime after, Pageable page);

    List<Booking> findALLByItemOwnerIdAndStartIsAfterOrderByStartDesc(Long ownerId, LocalDateTime date, Pageable page);

    List<Booking> findALLByItemOwnerIdAndEndIsBeforeOrderByStartDesc(Long ownerId, LocalDateTime date, Pageable page);

    List<Booking> findAllByBookerIdAndStatusOrderByStartDesc(Long bookerId, Status status, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStatusOrderByStartDesc(Long ownerId, Status status, Pageable page);

    List<Booking> findAllByItemIdAndBookerIdAndEndIsBefore(Long itemId, Long bookerId, LocalDateTime localDateTime);
}