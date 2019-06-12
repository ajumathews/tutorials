package com.grace.tutorials.springboot.web.service;

import com.grace.tutorials.springboot.business.domain.RoomReservation;
import com.grace.tutorials.springboot.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReservationServiceController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{date}")
    public List<RoomReservation> getRoomReservation(@PathVariable("date") String dateString) {
        List<RoomReservation> roomReservationList = reservationService.getRoomReservationForDate(dateString);
        return roomReservationList;
    }

}
