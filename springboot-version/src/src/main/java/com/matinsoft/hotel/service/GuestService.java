package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.Guest;

public interface GuestService {

	Guest save(Guest guest, Integer employeeId);

	Guest update(Guest guest, Integer employeeId);

	void deleteById(Integer Id, Integer employeeId);

	void deleteAll(List<Integer> Ids, Integer employeeId);

	Guest findById(Integer id);

	List<Guest> findAll();
}
