package ru.rksp.demchenko.listener;

import ru.rksp.demchenko.dto.EventDto;
import ru.rksp.demchenko.entity.EventEntity;
import ru.rksp.demchenko.repo.EventRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    private final EventRepository repo;

    public EventListener(EventRepository repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = "events.raw")
    public void listen(EventDto dto) {
        EventEntity e = new EventEntity();
        e.setИдентификатор(dto.id);
        e.setНомер_чека(dto.receiptNumber);
        e.setНаименование_магазина(dto.storeName);
        e.setТовар(dto.product);
        e.setЦена(dto.price);
        e.setДата_события(dto.eventDate);
        repo.save(e);
    }
}
