package ru.practicum.shareit.item;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.constants.Constants;

import javax.validation.Valid;
import java.util.List;

/**
 * TODO Sprint add-controllers.
 */

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private ItemService service;

    @PostMapping
    public ItemDto create(@RequestHeader(Constants.X_SHARER_USER_ID) long userId,
                          @Valid @RequestBody ItemDto itemDto) {
        return service.create(userId, itemDto);
    }

    @PatchMapping("/{id}")
    public ItemDto update(@PathVariable long id,
                          @RequestHeader(Constants.X_SHARER_USER_ID) long userId,
                          @RequestBody ItemDto itemDto) {
        return service.update(id, userId, itemDto);
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable long id) {
        return service.getItemById(id);
    }

    @GetMapping
    public List<ItemDto> getAllByOwner(@RequestHeader(Constants.X_SHARER_USER_ID) long userId) {
        return service.getAllItemsByOwner(userId);
    }

    @GetMapping("/search")
    public List<ItemDto> findByQuery(@RequestParam String text) {
        return service.findByQuery(text);
    }
}