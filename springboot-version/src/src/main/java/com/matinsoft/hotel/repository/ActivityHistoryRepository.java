package com.matinsoft.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matinsoft.hotel.entity.ActivityHistory;

@Repository
public interface ActivityHistoryRepository extends JpaRepository<ActivityHistory, Long> {

    List<ActivityHistory> findByEmployeeID(Integer employeeID);

    List<ActivityHistory> findByEntityId(Long entityID);

    List<ActivityHistory> findByEntityType(String entityType);

    List<ActivityHistory> findByAction(String action);
}

