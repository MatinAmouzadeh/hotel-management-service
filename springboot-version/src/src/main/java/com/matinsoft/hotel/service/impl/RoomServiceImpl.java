package com.matinsoft.hotel.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.Room;
import com.matinsoft.hotel.repository.RoomRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;
import com.matinsoft.hotel.service.RoomService;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService{

	private RoomRepository roomRepository;

	private ActivityHistoryService activityHistoryService;

	public RoomServiceImpl(RoomRepository theRoomRepository,
			ActivityHistoryService theActivityHistoryService) {
		roomRepository=theRoomRepository;
		activityHistoryService=theActivityHistoryService;
	}

	@Transactional
	@Override
	public Room save(Room room, Integer employeeId) {

		if (room.getNightlyPrice()<=0) {
			throw new IllegalArgumentException("Invalid nightly price");
		}

		if (room.getCapacity()<=0) {
			throw new IllegalArgumentException("Invalid room capacity");
		}

		if (room.getType()==null ||room.getType().isBlank()) {
			throw new IllegalArgumentException("Room type is required");
		}

		if (room.getStatus()==null|| room.getStatus().isBlank()) {
			room.setStatus("AVAILABLE");
		}

		room.setReservationID(null);

		Room saved = roomRepository.save(room);
		activityHistoryService.log("ROOM_CREATED", "Room created", "ROOM",
				saved.getRoomID().longValue(), employeeId);

		return saved;

	}

	@Transactional
	@Override
	public Room update(Room room, Integer employeeId) {

		Room existing = roomRepository.findById(room.getRoomID())
				.orElseThrow(() -> new IllegalArgumentException("Room not found"));

		if (room.getNightlyPrice() > 0) {
			existing.setNightlyPrice(room.getNightlyPrice());
		}

		if (room.getCapacity() > 0) {
			existing.setCapacity(room.getCapacity());
		}

		if (room.getType() != null && !room.getType().isBlank()) {
			existing.setType(room.getType());
		}

		// تغییر وضعیت فقط اگر رزرو نشده
		if (room.getStatus() != null && !room.getStatus().isBlank()) {
			if (existing.getReservationID() != null) {
				throw new IllegalStateException(
						"Cannot change status of reserved room");
			}
			existing.setStatus(room.getStatus());
		}
		Room updated = roomRepository.save(existing);
		activityHistoryService.log("ROOM_UPDATED", "Room updated", "ROOM",
				updated.getRoomID().longValue(), employeeId);

		return updated;
	}

	@Transactional
	@Override
	public void deleteById(Integer id, Integer employeeId) {

		Room room=roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Room not found"));

		if (room.getReservationID()!=null) {
			throw new IllegalStateException("Cannot delete a reserved room");
		}

		roomRepository.deleteById(id);

		activityHistoryService.log("ROOM_DELETED", "Room deleted", "ROOM",
				id.longValue(), employeeId);
	}

	@Transactional
	@Override
	public void deleteAll(List<Integer> ids, Integer employeeId) {

		for (Integer id:ids) {
			Room room=roomRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException(
							"Room not found: " + id));

			if (room.getReservationID()!=null) {
				throw new IllegalStateException("Cannot delete reserved room: " + id);
			}
		}

		roomRepository.deleteAllById(ids);

		for (Integer id:ids) {
			activityHistoryService.log("ROOM_DELETED", "Room deleted", "ROOM",
					id.longValue(), employeeId);
		}
	}

	@Override
	public Room findById(Integer id) {
		return roomRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Room not found"));
	}

	@Override
	public List<Room> findAll() {
		return roomRepository.findAll();
	}

	@Override
	public List<Room> findAvailableRooms() {
		return roomRepository.findByStatus("AVAILABLE");
	}
}