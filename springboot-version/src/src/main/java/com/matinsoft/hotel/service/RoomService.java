package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.Room;

public interface RoomService {

	Room save(Room room, Integer employeeId);

	Room update(Room room, Integer employeeId);

	void deleteById(Integer id, Integer employeeId);

	void deleteAll(List<Integer> ids, Integer employeeId);

	Room findById(Integer id);

	List<Room> findAll();

	List<Room> findAvailableRooms();

}
