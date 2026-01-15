package ru.rksp.demchenko.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "сырые_события_покупок")
public class EventEntity {

    @Id
    private UUID идентификатор;
    private String номер_чека;
    private String наименование_магазина;
    private String товар;
    private BigDecimal цена;
    private LocalDateTime дата_события;

    // getters/setters omitted for brevity
}
