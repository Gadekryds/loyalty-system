package dev.gadekryds.product.features.createProduct;

import dev.gadekryds.product.util.ProductEvent;

import java.util.UUID;

public record ProductCreatedEvent (UUID id, String name) implements ProductEvent {
}
