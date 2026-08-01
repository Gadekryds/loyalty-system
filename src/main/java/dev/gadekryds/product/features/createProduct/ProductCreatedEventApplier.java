package dev.gadekryds.product.features.createProduct;

import dev.gadekryds.product.Product;
import dev.gadekryds.product.ProductRepository;
import dev.gadekryds.product.util.ProductEventApplier;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedEventApplier implements ProductEventApplier<ProductCreatedEvent> {
    private final ProductRepository repo;
    public ProductCreatedEventApplier(ProductRepository repo) {
        this.repo = repo;
    }
    @Override
    public void apply(Product target, ProductCreatedEvent event) {

        target.setId(event.id());
        target.setName(event.name());

        repo.Add(target);
    }

    @Override
    public Class<ProductCreatedEvent> eventType() {
        return ProductCreatedEvent.class;
    }
}
