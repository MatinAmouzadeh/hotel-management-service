package com.matinsoft.hotel.service;

import java.util.List;

import com.matinsoft.hotel.entity.ActivityHistory;

public interface ActivityHistoryService {

    ActivityHistory findById(Long id);

    List<ActivityHistory> findAll();

    void log(String action, String description,
    		String entityType, Long entityID,
    		Integer employeeId);

	List<ActivityHistory> findByEntityId(Long entityId);

	List<ActivityHistory> findByAction(String action);

	List<ActivityHistory> findByEmployeeId(Integer employeeId);
}