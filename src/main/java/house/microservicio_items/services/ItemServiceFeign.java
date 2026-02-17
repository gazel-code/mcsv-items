package house.microservicio_items.services;

import feign.FeignException;
import house.microservicio_items.clients.ProductFeignClient;
import house.microservicio_items.models.Item;
import house.microservicio_items.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient client;

    @Override
    public List<Item> findAll() {
        return client.findAll()
                .stream()
                .map(product -> new Item(product, new Random().nextInt(10) + 1))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
//        Product product = client.findById(id);
//        if (product == null) {
//            return Optional.empty();
//        }
//        return Optional.of(new Item(product, new Random().nextInt(10) + 1));
        try {
            Product product = client.findById(id);
            return Optional.of(new Item(product, new Random().nextInt(10) + 1));
        } catch (FeignException e) {
            return Optional.empty();
        }
    }
}
