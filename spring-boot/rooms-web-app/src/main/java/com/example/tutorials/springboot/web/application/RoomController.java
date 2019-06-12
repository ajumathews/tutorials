package com.example.tutorials.springboot.web.application;

import com.example.tutorials.springboot.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }


    @GetMapping
    public String getRooms(Model model) {
        model.addAttribute("rooms", roomService.getRooms());
        return "rooms";
    }
}
