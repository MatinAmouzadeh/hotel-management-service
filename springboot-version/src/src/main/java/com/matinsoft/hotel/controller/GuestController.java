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

import com.matinsoft.hotel.entity.Guest;
import com.matinsoft.hotel.service.GuestService;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

	private final GuestService guestService;

	@Autowired
	public GuestController(GuestService theGuestService) {
		guestService=theGuestService;
	}

	@PostMapping
	public Guest save(@RequestBody Guest guest,
			@RequestHeader("Employee-Id") Integer employeeId) {

		return guestService.save(guest, employeeId);
	}

	// UPDATE
	@PutMapping
	public Guest update(@RequestBody Guest guest,
			@RequestHeader("Employee-Id") Integer employeeId) {

		return guestService.update(guest, employeeId);
	}

	// DELETE SINGLE
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Integer id,
			@RequestHeader("Employee-Id") Integer employeeId) {
		guestService.deleteById(id, employeeId);
	}

	// DELETE MULTIPLE
	@DeleteMapping("/bulk")
	public void deleteAll(@RequestBody List<Integer> ids,
			@RequestHeader("Employee-Id") Integer employeeId) {
		guestService.deleteAll(ids, employeeId);
	}

	// GET SINGLE
	@GetMapping("/{id}")
	public Guest findById(@PathVariable Integer id) {
		return guestService.findById(id);
	}

	// GET ALL
	@GetMapping
	public List<Guest> findAll() {
		return guestService.findAll();
	}
}
