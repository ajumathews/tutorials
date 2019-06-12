package com.grace.tutorials.springboot.data.repository;

import com.grace.tutorials.springboot.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByDate(Date date);
}
