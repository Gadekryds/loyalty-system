package dev.gadekryds.product.util;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.gadekryds.common.eventsourcing.Event;
import dev.gadekryds.product.Product;
import dev.gadekryds.product.features.createProduct.ProductCreatedEvent;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes(
        @JsonSubTypes.Type(value = ProductCreatedEvent.class, name = "ProductCreatedEvent")
)
public interface ProductEvent extends Event<Product> {
}
