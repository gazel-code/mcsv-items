package house.microservicio_items.services;

import house.microservicio_items.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();

    Optional<Item> findById(Long id);
}
