package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.dto.ReservationRequest;
import com.matinsoft.hotel.dto.ReservationResponse;
import com.matinsoft.hotel.entity.Reservation;

public interface ReservationService {

	ReservationResponse save(ReservationRequest reservationRequest, Integer employeeId);

	Reservation update(ReservationRequest reservationRequest, Integer employeeId);

	void deleteById(Long id, Integer employeeId);

	void deleteAll(List<Long> ids, Integer employeeId);

	Reservation findById(Long id);

	List<Reservation> findAll();
}
