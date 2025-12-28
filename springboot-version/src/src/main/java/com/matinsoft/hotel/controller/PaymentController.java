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

import com.matinsoft.hotel.entity.Payment;
import com.matinsoft.hotel.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	private final PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping
	public Payment create(@RequestBody Payment payment,
			@RequestHeader("Role") String role,
			@RequestHeader("Employee-Id") Integer employeeId) {

		if (!role.equals("Employee") && !role.equals("SuperAdmin")) {
			throw new SecurityException("Access denied");
		}

		return paymentService.save(payment, employeeId);
	}

	@PutMapping
	public Payment update(@RequestBody Payment payment,
			@RequestHeader("Role") String role,
			@RequestHeader("Employee-Id") Integer employeeId) {

		if (!role.equals("Employee") && !role.equals("SuperAdmin")) {
			throw new SecurityException("Access denied");
		}

		return paymentService.update(payment, employeeId);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id,
			@RequestHeader("Role") String role,
			@RequestHeader("Employee-Id") Integer employeeId) {

		if (!role.equals("SuperAdmin")) {
			throw new SecurityException("Access denied");
		}

		paymentService.deleteById(id, employeeId);
	}

	@GetMapping
	public List<Payment> findAll(@RequestHeader("Role") String role) {

		if (!role.equals("SuperAdmin")) {
			throw new SecurityException("Access denied");
		}

		return paymentService.findAll();
	}

	@GetMapping("/by-reservation/{reservationId}")
	public Payment getByReservation(@PathVariable Long reservationId,
			@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
			throw new SecurityException("Access denied");
		}

		return paymentService.findByReservationId(reservationId);
	}

}
