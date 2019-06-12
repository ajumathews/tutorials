package com.grace.tutorials.springboot.runner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grace.tutorials.springboot.data.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RoomRunner implements CommandLineRunner {

    @Value("${amqp.queue.name}")
    private String queueName;

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomRunner.class);

    private final RabbitTemplate rabbitTemplate;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ConfigurableApplicationContext context;


    @Autowired
    public RoomRunner(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, ConfigurableApplicationContext context) {
        super();
        this.restTemplate = new RestTemplate();
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.context = context;

    }

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8080/api/rooms";
        Room[] roomArray = restTemplate.getForObject(url, Room[].class);
        List<Room> rooms = Arrays.asList(roomArray);
        rooms.forEach(room -> {
            System.out.println(room);

            try {
                String jsonRoom = objectMapper.writeValueAsString(room);
                rabbitTemplate.convertAndSend(queueName,jsonRoom);
                LOGGER.info("send Message");
            } catch (JsonProcessingException e) {
                LOGGER.error("error");
            }
        });
        System.exit(SpringApplication.exit(context));
    }

}
