package dev.gadekryds.product.util;

import dev.gadekryds.common.eventsourcing.EventApplier;
import dev.gadekryds.product.Product;

public interface ProductEventApplier<E extends ProductEvent> extends EventApplier<Product, E> {
}
