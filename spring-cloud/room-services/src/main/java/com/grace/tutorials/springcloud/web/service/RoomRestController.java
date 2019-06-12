package com.grace.tutorials.springcloud.web.service;

import com.grace.tutorials.springcloud.data.entity.Room;
import com.grace.tutorials.springcloud.data.repository.RoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "rooms", description = "Data service on rooms", tags = "rooms")
public class RoomRestController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomRestController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rooms")
    @ApiOperation(value = "Get All Rooms",notes = "Get all rooms in the system", nickname = "getRooms")
    public List<Room> getRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isEmpty(roomNumber)) {
            return (List<Room>) this.roomRepository.findAll();
        } else {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        }
    }
}
