package com.example.tutorials.springboot.web.service;

import com.example.tutorials.springboot.data.Room;
import com.example.tutorials.springboot.service.RoomService;
import com.grace.tutorials.springboot.aspect.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RoomRestController {

    private final RoomService roomService;

    @Autowired
    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    @Timed
    public List<Room> getRooms() {
        return roomService.getRooms();
    }
}
