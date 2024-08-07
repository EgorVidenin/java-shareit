package ru.practicum.shareit.item.repository;


import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOwnerIdOrderById(Long ownerId, Pageable page);

    List<Item> findByNameIgnoreCaseContainingAndAvailableTrueOrDescriptionIgnoreCaseContainingAndAvailableTrue(String name, String description, Pageable page);

    List<Item> findAllByRequestId(Long requestId);
}