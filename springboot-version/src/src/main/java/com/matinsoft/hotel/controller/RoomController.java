package com.matinsoft.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matinsoft.hotel.entity.Room;
import com.matinsoft.hotel.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	private final RoomService roomService;

	@Autowired
	public RoomController(RoomService theRoomService) {
		roomService=theRoomService;
	}

	@PostMapping
    public Room save(@RequestBody Room room,
    		@RequestHeader("Employee-Id") Integer employeeId) {

            return roomService.save(room, employeeId);
    }

    // UPDATE
	@PutMapping
	public Room update(@RequestBody Room room,
	        @RequestHeader("Employee-Id") Integer employeeId) {

	        return roomService.update(room, employeeId);
	}

    // DELETE SINGLE
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id,
    		@RequestHeader("Employee-Id") Integer employeeId) {
    	roomService.deleteById(id, employeeId);
    }

    // DELETE MULTIPLE
    @DeleteMapping("/bulk")
    public void deleteAll(@RequestBody List<Integer> ids,
    		@RequestHeader("Employee-Id") Integer employeeId) {
    	roomService.deleteAll(ids, employeeId);
    }

    // GET SINGLE
    @GetMapping("/{id}")
    public Room findById(@PathVariable Integer id) {
        return roomService.findById(id);
    }

    // GET ALL
    @GetMapping
    public List<Room> findAll() {
        return roomService.findAll();
    }
}
