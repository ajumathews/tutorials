package com.grace.tutorials.springcloud.data.repository;

import com.grace.tutorials.springcloud.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    Room findByRoomNumber(String roomNumber);
}
