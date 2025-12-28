package com.matinsoft.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matinsoft.hotel.entity.Companion;
import com.matinsoft.hotel.service.CompanionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api/companions")
public class CompanionController {

	private final CompanionService companionService;

	@Autowired
	public CompanionController(CompanionService companionService) {
		this.companionService = companionService;
	}

	@PostMapping
	public Companion save(@RequestBody Companion companion,
			@RequestHeader("Employee-Id") Integer employeeId) {

		return companionService.save(companion, employeeId);
	}

	// UPDATE
	@PutMapping
	public Companion update(@RequestBody Companion companion,
			@RequestHeader("Employee-Id") Integer employeeId) {

		return companionService.update(companion, employeeId);
	}

	@GetMapping("/guest/{guestId}")
	public List<Companion> findByGuest(@PathVariable Integer guestId) {
		return companionService.findByGuestId(guestId);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id, @RequestHeader("Employee-Id") Integer employeeId) {
		companionService.deleteById(id, employeeId);
	}

	// DELETE MULTIPLE
	@DeleteMapping("/bulk")
	public void deleteAll(@RequestBody List<Long> ids, @RequestHeader("Employee-Id") Integer employeeId) {
		companionService.deleteAll(ids, employeeId);
	}
}
