package dev.gadekryds.product.dto;

import dev.gadekryds.common.Request;
import dev.gadekryds.product.Product;

public record CreateProductCommand (
        String title,
        String description
) implements Request<Product> {
}
