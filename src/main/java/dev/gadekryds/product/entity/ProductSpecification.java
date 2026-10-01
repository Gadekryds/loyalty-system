package dev.gadekryds.product.entity;

import jakarta.persistence.Entity;

@Entity
public class ProductSpecification {
    private Integer id;
    private Attribute attribute;
    private Product product;
    private String specValue;
}
