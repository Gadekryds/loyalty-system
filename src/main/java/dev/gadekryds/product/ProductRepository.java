package dev.gadekryds.product;

import dev.gadekryds.product.util.ProductEvent;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.function.Predicate;

@Component
public class ProductRepository {
    private static Map<UUID, Product> products = new Hashtable<>();
    private static Map<UUID, String> events = new Hashtable<>();

    public void Add(Product product) {
        products.put(product.getId(), product);
    }

    public void Update(Product product) {
        products.put(product.getId(), product);
    }

    public void Delete(Product product) {
        products.remove(product.getId());
    }

    public List<ProductEvent> GetProductEvents(UUID productId) {
        ObjectMapper objectMapper = new ObjectMapper();
        return events.get(productId).lines()
                .map(s -> objectMapper.readValue(s, ProductEvent.class))
                .toList();
    }

    public void AddEvent(UUID productId, ProductEvent event) {
        events.put(productId, event.toString());
    }

    public List<Product> GetAll(boolean useFilter, Predicate<Product> filter) {
        var items = products.entrySet();

        return useFilter
                ? items
                .stream()
                    .filter(v -> filter.test(v.getValue()))
                    .map(Map.Entry::getValue)
                    .toList()
                : items
                    .stream()
                    .map(Map.Entry::getValue)
                    .toList();
    }

    public Product Get(UUID uuid) {
        return products.get(uuid);
    }


}
