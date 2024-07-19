package ru.practicum.shareit.booking.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.practicum.shareit.booking.dto.BookingDtoRequest;
import ru.practicum.shareit.booking.dto.BookingDtoResponse;
import ru.practicum.shareit.booking.model.State;
import ru.practicum.shareit.booking.service.BookingService;
import ru.practicum.shareit.constants.Constants;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = BookingController.class)
class BookingControllerTest {
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private BookingService bookingService;
    @Autowired
    private MockMvc mvc;
    private final EasyRandom generator = new EasyRandom();

    @Test
    void saveBooking() throws Exception {
        BookingDtoRequest bookingDtoRequest = generator.nextObject(BookingDtoRequest.class);
        BookingDtoResponse bookingDtoResponse = generator.nextObject(BookingDtoResponse.class);
        when(bookingService.save(anyLong(), any(BookingDtoRequest.class))).thenReturn(bookingDtoResponse);

        mvc.perform(post("/bookings")
                        .content(mapper.writeValueAsString(bookingDtoRequest))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bookingDtoResponse.getId())))
                .andExpect(jsonPath("$.booker.id", is(bookingDtoResponse.getBooker().getId())))
                .andExpect(jsonPath("$.item.id", is(bookingDtoResponse.getItem().getId())))
                .andExpect(jsonPath("$.item.name", is(bookingDtoResponse.getItem().getName())))
                .andExpect(jsonPath("$.status", is(bookingDtoResponse.getStatus().toString())))
                .andExpect(jsonPath("$.start", is(bookingDtoResponse.getStart().toString())))
                .andExpect(jsonPath("$.end", is(bookingDtoResponse.getEnd().toString())));
    }

    @Test
    void saveBookingWhenError() throws Exception {
        BookingDtoRequest bookingDtoRequest = generator.nextObject(BookingDtoRequest.class);
        bookingDtoRequest.setItemId(null);
        when(bookingService.save(anyLong(), any(BookingDtoRequest.class))).thenThrow(new RuntimeException());

        mvc.perform(post("/bookings")
                        .content(mapper.writeValueAsString(bookingDtoRequest))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.error").value(containsString("must not be null")));
    }


    @Test
    void approveBooking() throws Exception {
        BookingDtoResponse bookingDtoResponse = generator.nextObject(BookingDtoResponse.class);
        when(bookingService.approveBooking(anyLong(), anyLong(), anyBoolean())).thenReturn(bookingDtoResponse);

        mvc.perform(patch("/bookings/{bookingId}", 1)
                        .queryParam("approved", "true")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bookingDtoResponse.getId())))
                .andExpect(jsonPath("$.booker.id", is(bookingDtoResponse.getBooker().getId())))
                .andExpect(jsonPath("$.item.id", is(bookingDtoResponse.getItem().getId())))
                .andExpect(jsonPath("$.item.name", is(bookingDtoResponse.getItem().getName())))
                .andExpect(jsonPath("$.status", is(bookingDtoResponse.getStatus().toString())))
                .andExpect(jsonPath("$.start", is(bookingDtoResponse.getStart().toString())))
                .andExpect(jsonPath("$.end", is(bookingDtoResponse.getEnd().toString())));
    }

    @Test
    void getBookingById() throws Exception {
        BookingDtoResponse bookingDtoResponse = generator.nextObject(BookingDtoResponse.class);
        when(bookingService.getBookingById(anyLong(), anyLong())).thenReturn(bookingDtoResponse);

        mvc.perform(get("/bookings/{bookingId}", 1)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(bookingDtoResponse.getId())))
                .andExpect(jsonPath("$.booker.id", is(bookingDtoResponse.getBooker().getId())))
                .andExpect(jsonPath("$.item.id", is(bookingDtoResponse.getItem().getId())))
                .andExpect(jsonPath("$.item.name", is(bookingDtoResponse.getItem().getName())))
                .andExpect(jsonPath("$.status", is(bookingDtoResponse.getStatus().toString())))
                .andExpect(jsonPath("$.start", is(bookingDtoResponse.getStart().toString())))
                .andExpect(jsonPath("$.end", is(bookingDtoResponse.getEnd().toString())));
    }

    @Test
    void getAllBookingsByUserId() throws Exception {
        BookingDtoResponse bookingDtoResponse = generator.nextObject(BookingDtoResponse.class);
        List<BookingDtoResponse> bookingDtoResponses = List.of(bookingDtoResponse);
        when(bookingService.getAllBookingsByUserId(anyLong(), any(State.class), anyInt(), anyInt()))
                .thenReturn(bookingDtoResponses);

        mvc.perform(get("/bookings")
                        .queryParam("state", "ALL")
                        .queryParam("from", "0")
                        .queryParam("size", "1")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]['id']", is(bookingDtoResponses.get(0).getId())))
                .andExpect(jsonPath("$.[0]['booker']['id']", is((bookingDtoResponses.get(0).getBooker().getId()))))
                .andExpect(jsonPath("$.[0]['item']['id']", is((bookingDtoResponses.get(0).getItem().getId()))))
                .andExpect(jsonPath("$.[0]['item']['name']", is((bookingDtoResponses.get(0).getItem().getName()))))
                .andExpect(jsonPath("$.[0]['status']", is((bookingDtoResponses.get(0).getStatus().toString()))))
                .andExpect(jsonPath("$.[0]['start']", is((bookingDtoResponses.get(0).getStart().toString()))))
                .andExpect(jsonPath("$.[0]['end']", is((bookingDtoResponses.get(0).getEnd().toString()))));
    }

    @Test
    void getAllBookingsByOwnerId() throws Exception {

        BookingDtoResponse bookingDtoResponse = generator.nextObject(BookingDtoResponse.class);
        List<BookingDtoResponse> bookingDtoResponses = List.of(bookingDtoResponse);
        when(bookingService.getAllBookingsByOwnerId(anyLong(), any(State.class), anyInt(), anyInt()))
                .thenReturn(bookingDtoResponses);

        mvc.perform(get("/bookings/owner/")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header(Constants.HEADER_USER_ID, 2L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]['id']", is(bookingDtoResponses.get(0).getId())))
                .andExpect(jsonPath("$.[0]['booker']['id']", is((bookingDtoResponses.get(0).getBooker().getId()))))
                .andExpect(jsonPath("$.[0]['item']['id']", is((bookingDtoResponses.get(0).getItem().getId()))))
                .andExpect(jsonPath("$.[0]['item']['name']", is((bookingDtoResponses.get(0).getItem().getName()))))
                .andExpect(jsonPath("$.[0]['status']", is((bookingDtoResponses.get(0).getStatus().toString()))))
                .andExpect(jsonPath("$.[0]['start']", is((bookingDtoResponses.get(0).getStart().toString()))))
                .andExpect(jsonPath("$.[0]['end']", is((bookingDtoResponses.get(0).getEnd().toString()))));
    }
}