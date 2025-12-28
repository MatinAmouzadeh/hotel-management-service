package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.Companion;

public interface CompanionService {

	Companion save(Companion companion, Integer employeeId);

	Companion update(Companion companion, Integer employeeId);

	void deleteById(Long Id, Integer employeeId);

	void deleteAll(List<Long> Ids, Integer employeeId);

	Companion findById(Long id);

	List<Companion> findAll();

	List<Companion> findByGuestId(Integer guestId);
}
