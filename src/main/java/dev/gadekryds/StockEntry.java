package dev.gadekryds;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class StockEntry {
    private UUID id;
    private UUID productId;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private LocalDateTime entryDate;
    private LocalDateTime purchaseDate;
}
