package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.Payment;

public interface PaymentService{

	Payment save(Payment payment, Integer employeeId);

	Payment update(Payment payment, Integer employeeId);

	void deleteById(Integer id, Integer employeeId);

	void deleteAll(List<Integer> ids, Integer employeeId);

	Payment findById(Integer id);

	List<Payment> findAll();

	Payment findByReservationId(Long reservationId);
}