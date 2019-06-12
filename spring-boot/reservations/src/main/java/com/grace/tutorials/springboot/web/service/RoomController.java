package com.grace.tutorials.springboot.web.service;

import com.grace.tutorials.springboot.data.entity.Room;
import com.grace.tutorials.springboot.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();

        Iterable<Room> results = roomRepository.findAll();
        results.forEach(room -> {
            rooms.add(room);
        });
        return rooms;

    }
}
