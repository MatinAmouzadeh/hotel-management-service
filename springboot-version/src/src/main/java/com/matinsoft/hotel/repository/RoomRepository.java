package com.matinsoft.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

	List<Room> findByReservationID(Long reservationID);

	 List<Room> findByStatus(String status);

}
