package dev.gadekryds.product;

import dev.gadekryds.common.Event;

public class ProductService<E extends Event<Product>> {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public void Apply(E event) {

    }
}
