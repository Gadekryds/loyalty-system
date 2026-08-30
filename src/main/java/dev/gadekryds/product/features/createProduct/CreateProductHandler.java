package dev.gadekryds.product.features.createProduct;

import dev.gadekryds.common.RequestHandler;
import dev.gadekryds.product.Product;
import dev.gadekryds.product.dto.CreateProductCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateProductHandler implements RequestHandler<Product, CreateProductCommand> {

    @Override
    public Product Handle(CreateProductCommand command) {

        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(command.title());
        return product;
    }
}
