package ru.practicum.shareit.item.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByOwnerIdOrderById(Long ownerId, Pageable page);

    List<Item> findByNameIgnoreCaseContainingAndAvailableTrueOrDescriptionIgnoreCaseContainingAndAvailableTrue(String name, String description, Pageable page);

    @NotNull List<ItemDto> findAllByRequestId(Long requestId);

    List<Item> findByRequestIdIn(List<Long> requestIds);
}