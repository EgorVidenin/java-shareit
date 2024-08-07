package ru.practicum.shareit.booking.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.shareit.booking.dto.BookingDtoRequest;
import ru.practicum.shareit.booking.dto.BookingDtoResponse;
import ru.practicum.shareit.booking.model.State;
import ru.practicum.shareit.booking.service.BookingService;
import ru.practicum.shareit.constants.Constants;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public BookingDtoResponse saveBooking(@RequestHeader(Constants.HEADER_USER_ID) Long userId,
                                          @RequestBody @Valid BookingDtoRequest bookingDtoRequest) {
        log.info("Post-запрос saveBooking");
        return bookingService.save(userId, bookingDtoRequest);
    }

    @PatchMapping("/{bookingId}")
    public BookingDtoResponse approveBooking(@RequestHeader(Constants.HEADER_USER_ID) Long userId,
                                             @PathVariable Long bookingId,
                                             @RequestParam Boolean approved) {
        log.info("Patch-запрос approveBooking");
        return bookingService.approveBooking(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    BookingDtoResponse getBookingById(@RequestHeader(Constants.HEADER_USER_ID) Long userId,
                                      @PathVariable Long bookingId) {
        log.info("Get-запрос getBookingById");
        return bookingService.getBookingById(userId, bookingId);
    }

    @GetMapping
    List<BookingDtoResponse> getAllBookingsByUserId(@RequestHeader(Constants.HEADER_USER_ID) Long userId,
                                                    @RequestParam(defaultValue = "ALL", required = false) State state,
                                                    @PositiveOrZero @RequestParam(defaultValue = "0", required = false) Integer from,
                                                    @Positive @RequestParam(defaultValue = "10", required = false) Integer size) {
        log.info("Get-запрос getAllBookingsByUserId");
        return bookingService.getAllBookingsByUserId(userId, state, from, size);
    }


    @GetMapping("/owner")
    List<BookingDtoResponse> getAllBookingsByOwnerId(@RequestHeader(Constants.HEADER_USER_ID) Long ownerId,
                                                     @RequestParam(defaultValue = "ALL", required = false) State state,
                                                     @PositiveOrZero @RequestParam(defaultValue = "0", required = false) Integer from,
                                                     @Positive @RequestParam(defaultValue = "10", required = false) Integer size) {
        log.info("Get-запрос getAllBookingsByOwnerId");
        return bookingService.getAllBookingsByOwnerId(ownerId, state, from, size);
    }
}