package com.matinsoft.hotel.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ActivityHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OperationID")
	private Long operationID;

	@Column(name = "Time")
	private LocalDateTime time;

	@Column(name = "Action")
	private String action;

	@Column(name = "Description")
	private String description;

	@Column(name = "EntityType")
	private String entityType;

	@Column(name = "EntityID")
	private Long entityId;

	@Column(name = "EmployeeID")
	private Integer employeeID;

	//**********************************************\\

	public ActivityHistory() {

	}

	public ActivityHistory(LocalDateTime time, String action, String description, String entityType, Long entityId,
			Integer employeeID) {
		this.time = time;
		this.action = action;
		this.description = description;
		this.entityType = entityType;
		this.entityId = entityId;
		this.employeeID = employeeID;
	}

	//**********************************************\\

	public Long getOperationID() {
		return operationID;
	}

	public void setOperationID(Long operationID) {
		this.operationID = operationID;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Long getEntityID() {
		return entityId;
	}

	public void setEntityID(Long entityID) {
		this.entityId = entityID;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	//**********************************************\\

	@Override
	public String toString() {
		return "ActivityHistory [operationID=" + operationID + ", time=" + time + ", action=" + action
				+ ", description=" + description + ", entityType=" + entityType + ", entityId=" + entityId
				+ ", employeeID=" + employeeID + "]";
	}
}