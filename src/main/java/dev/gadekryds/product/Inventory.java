package dev.gadekryds.product;

import java.math.BigDecimal;
import java.util.UUID;

public class Inventory {
    private int id;
    private UUID productId;
    private int quantity;
    private BigDecimal  weightedAverageCost;
}
