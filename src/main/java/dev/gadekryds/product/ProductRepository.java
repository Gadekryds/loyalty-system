package dev.gadekryds.product;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class ProductRepository {
    private static Set<Product> products = new HashSet<>();
    private static Dictionary<UUID, String> events = new Hashtable<>();

    public void Add(Product product) {

    }

    public void Update(Product product) {

    }

    public void Delete(Product product) {

    }

    public List<Product> GetAll(boolean useFilter, Predicate<Product> filter) {
        return products
                .stream()
                .filter(filter)
                .toList();
    }

    public Product Get(UUID uuid) {
        return products.stream()
                .filter(u -> u.getId().equals(uuid))
                .findFirst()
                .orElseThrow();
    }


}
