package dev.gadekryds.product;

import dev.gadekryds.common.eventsourcing.Event;
import dev.gadekryds.product.util.ProductBuilder;

public class ProductService<E extends Event<Product>> {

    ProductBuilder builder;
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public void Apply(E event) {

    }
}
