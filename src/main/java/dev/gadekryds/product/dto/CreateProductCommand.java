package dev.gadekryds.product.dto;

import dev.gadekryds.common.Command;
import dev.gadekryds.product.Product;

public record CreateProductCommand(
        String title,
        String description
) implements Command<Product> {
}
