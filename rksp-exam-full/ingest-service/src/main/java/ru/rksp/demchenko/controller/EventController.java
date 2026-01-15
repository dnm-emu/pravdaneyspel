package ru.rksp.demchenko.controller;

import ru.rksp.demchenko.dto.EventDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final RabbitTemplate rabbitTemplate;

    public EventController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody EventDto dto) {
        rabbitTemplate.convertAndSend("events.raw", dto);
        return ResponseEntity.ok().build();
    }
}
