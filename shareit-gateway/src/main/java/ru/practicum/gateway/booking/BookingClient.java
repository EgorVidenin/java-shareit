package ru.practicum.gateway.booking;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.gateway.booking.dto.BookingRequestDto;
import ru.practicum.gateway.booking.dto.BookingState;
import ru.practicum.gateway.client.BaseClient;

@Service
public class BookingClient extends BaseClient {
    private static final String API_PREFIX = "/bookings";

    @Autowired
    public BookingClient(@Value("${shareIt-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    public ResponseEntity<Object> getBookingsByUser(long userId, BookingState state, Integer from, Integer size) {
        Map<String, Object> parameters = Map.of(
                "state", state.name(),
                "from", from,
                "size", size
        );
        return getWithFullArguments("?state={state}&from={from}&size={size}", userId, parameters);
    }

    public ResponseEntity<Object> getBookingsByOwner(long userId, BookingState state, Integer from, Integer size) {
        Map<String, Object> parameters = Map.of(
                "state", state.name(),
                "from", from,
                "size", size
        );
        return getWithFullArguments("/owner?state={state}&from={from}&size={size}", userId, parameters);
    }


    public ResponseEntity<Object> bookItem(long userId, BookingRequestDto requestDto) {
        return postWithPathAndUserIdAndBody("", userId, requestDto);
    }

    public ResponseEntity<Object> getBooking(long userId, Long bookingId) {
        return getWithPathAndUserId("/" + bookingId, userId);
    }

    public ResponseEntity<Object> approveBooking(Long userId, Long bookingId, Boolean approved) {
        return patchWithPathAndUserId("/" + bookingId + "?approved=" + approved, userId);
    }
}