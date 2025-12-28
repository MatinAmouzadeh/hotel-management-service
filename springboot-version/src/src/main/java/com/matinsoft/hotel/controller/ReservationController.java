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

import com.matinsoft.hotel.dto.ReservationRequest;
import com.matinsoft.hotel.dto.ReservationResponse;
import com.matinsoft.hotel.entity.Reservation;
import com.matinsoft.hotel.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

	private final ReservationService reservationService;

	@Autowired
	public ReservationController(ReservationService theReservationService) {
		reservationService=theReservationService;
	}

	@PostMapping
	public ReservationResponse save(@RequestBody ReservationRequest reservationRequest,
			@RequestHeader("Employee-Id") Integer employeeId) {
		return reservationService.save(reservationRequest, employeeId);
	}

	// UPDATE
	@PutMapping
	public ReservationResponse update(
			@RequestBody ReservationRequest reservationRequest,
			@RequestHeader("Employee-Id") Integer employeeId) {

		Reservation updated = reservationService.update(reservationRequest, employeeId);

		return new ReservationResponse("Reservation updated", updated.getReservationID(),
				"UPDATED", null, null);
	}


	// DELETE SINGLE
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id,
			@RequestHeader("Employee-Id") Integer employeeId) {
		reservationService.deleteById(id, employeeId);
	}

	// DELETE MULTIPLE
	@DeleteMapping("/bulk")
	public void deleteAll(@RequestBody List<Long> ids,
			@RequestHeader("Employee-Id") Integer employeeId) {
		reservationService.deleteAll(ids, employeeId);
	}

	// GET SINGLE
	@GetMapping("/{id}")
	public Reservation findById(@PathVariable Long id) {
		return reservationService.findById(id);
	}

	// GET ALL
	@GetMapping
	public List<Reservation> findAll() {
		return reservationService.findAll();
	}
}
