package ru.rksp.demchenko.controller;

import ru.rksp.demchenko.repo.EventRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/events/count")
public class CountController {

    private final EventRepository repo;
    private final JdbcTemplate jdbc;

    public CountController(EventRepository repo, JdbcTemplate jdbc) {
        this.repo = repo;
        this.jdbc = jdbc;
    }

    @PostMapping
    public long count() {
        long count = repo.count();
        jdbc.update(
            "INSERT INTO агрегаты_событий_покупок VALUES (?, ?)",
            LocalDateTime.now(), count
        );
        return count;
    }
}
