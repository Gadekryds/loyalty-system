package dev.gadekryds.product.util;

import dev.gadekryds.common.EntityBuilder;
import dev.gadekryds.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBuilder extends EntityBuilder<Product, ProductEvent> {
    public ProductBuilder(List<ProductEventApplier<?>> appliers) {
        super(Product::new, appliers);
    }
}