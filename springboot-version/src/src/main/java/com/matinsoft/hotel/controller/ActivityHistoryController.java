package com.matinsoft.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matinsoft.hotel.entity.ActivityHistory;
import com.matinsoft.hotel.service.ActivityHistoryService;

@RestController
@RequestMapping("/api/activityHistory")
public class ActivityHistoryController {

	private final ActivityHistoryService activityHistoryService;

	@Autowired
	public ActivityHistoryController(ActivityHistoryService theActivityHistoryService) {
		activityHistoryService=theActivityHistoryService;
	}

	// GET SINGLE
	@GetMapping("/{id}")
	public ActivityHistory findById(@PathVariable Long id,
			@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
		    throw new SecurityException("Access denied");
		}

		return activityHistoryService.findById(id);
	}
	// GET ALL
	@GetMapping
	public List<ActivityHistory> findAll(@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
		    throw new SecurityException("Access denied");
		}

		return activityHistoryService.findAll();
	}

	@GetMapping("/by-employee/{employeeId}")
	public List<ActivityHistory> findByEmployee(
			@PathVariable Integer employeeId,
			@RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
		    throw new SecurityException("Access denied");
		}

		return activityHistoryService.findByEmployeeId(employeeId);
	}

	@GetMapping("/by-entity/{entityId}")
	public List<ActivityHistory> findByEntity(
	        @PathVariable Long entityId,
	        @RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
		    throw new SecurityException("Access denied");
		}

	    return activityHistoryService.findByEntityId(entityId);
	}

	@GetMapping("/by-action/{action}")
	public List<ActivityHistory> findByAction(
	        @PathVariable String action,
	        @RequestHeader("Role") String role) {

		if (!"SuperAdmin".equals(role)) {
		    throw new SecurityException("Access denied");
		}

	    return activityHistoryService.findByAction(action);
	}
}