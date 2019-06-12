package com.example.tutorials.springboot.service;

import com.example.tutorials.springboot.data.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private static List<Room> rooms = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, "Room" + i, "Q"));
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
