package com.grace.tutorials.springboot.web.application;

import com.grace.tutorials.springboot.business.domain.RoomReservation;
import com.grace.tutorials.springboot.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd");

    @Test
    public void testGetReservation() throws Exception {
        Date date = DATE_FORMAT.parse("2017-01-01");

        List<RoomReservation> mockRoomReservationList = new ArrayList<>();
        RoomReservation mockRoomReservation = new RoomReservation();
        mockRoomReservation.setLastName("Test");
        mockRoomReservation.setFirstName("Junit");
        mockRoomReservation.setGuestId(1);
        mockRoomReservation.setDate(date);
        mockRoomReservation.setRoomNumber("1");
        mockRoomReservation.setRoomId(1);
        mockRoomReservation.setRoomName("name");
        mockRoomReservationList.add(mockRoomReservation);

        given(reservationService.getRoomReservationForDate("2017-01-01")).willReturn(mockRoomReservationList);

        this.mockMvc.perform(get("/reservations?date=2017-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Junit")));

    }


}
