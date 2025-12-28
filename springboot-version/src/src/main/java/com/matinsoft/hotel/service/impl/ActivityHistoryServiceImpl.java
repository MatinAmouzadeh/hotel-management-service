package com.matinsoft.hotel.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.matinsoft.hotel.entity.ActivityHistory;
import com.matinsoft.hotel.repository.ActivityHistoryRepository;
import com.matinsoft.hotel.service.ActivityHistoryService;

@Service
public class ActivityHistoryServiceImpl implements ActivityHistoryService {

	private final ActivityHistoryRepository activityHistoryRepository;

	public ActivityHistoryServiceImpl(ActivityHistoryRepository activityHistoryRepository) {
		this.activityHistoryRepository = activityHistoryRepository;
	}

	@Override
	public ActivityHistory findById(Long id) {
		return activityHistoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Activity history not found"));
	}

	@Override
	public List<ActivityHistory> findAll() {
		return activityHistoryRepository.findAll();
	}

	@Override
	public void log(String action, String description,
    		String entityType, Long entityID,
    		Integer employeeId) {

		ActivityHistory history = new ActivityHistory();
		history.setEntityType(entityType);
		history.setDescription(description);
		history.setEntityID(entityID);
		history.setEmployeeID(employeeId);
		history.setTime(LocalDateTime.now());
		history.setAction(action);

		activityHistoryRepository.save(history);
	}

	@Override
	public List<ActivityHistory> findByEmployeeId(Integer employeeId) {
		return activityHistoryRepository.findByEmployeeID(employeeId);
	}

	@Override
	public List<ActivityHistory> findByEntityId(Long entityID) {
		return activityHistoryRepository.findByEntityId(entityID);
	}

	@Override
	public List<ActivityHistory> findByAction(String action) {
		return activityHistoryRepository.findByAction(action);
	}
}
