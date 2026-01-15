package ru.rksp.demchenko.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventDto {
    public UUID id;
    public String receiptNumber;
    public String storeName;
    public String product;
    public BigDecimal price;
    public LocalDateTime eventDate;
}
