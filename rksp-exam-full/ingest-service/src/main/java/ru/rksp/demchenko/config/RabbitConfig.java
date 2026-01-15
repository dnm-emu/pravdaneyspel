package ru.rksp.demchenko.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue eventsQueue() {
        return new Queue("events.raw", true);
    }
}
