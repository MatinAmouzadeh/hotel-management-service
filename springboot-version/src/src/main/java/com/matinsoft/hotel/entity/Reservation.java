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
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ReservationID")
	private Long reservationID;

	@Column(name = "Time")
	private LocalDateTime time;

	@Column(name = "DateOfArrival")
	private LocalDateTime dateOfArrival;

	@Column(name = "DepartureDate")
	private LocalDateTime departureDate;

	@Column(name = "EmployeeID")
	private Integer employeeID;

	@Column(name= "GuestID")
	private Integer guestID;

	//***************************************************\\

	public Reservation() {

	}

	public Reservation(LocalDateTime time, LocalDateTime dateOfArrival, LocalDateTime departureDate,
			Integer employeeID, Integer guestID) {
		this.time = time;
		this.dateOfArrival = dateOfArrival;
		this.departureDate = departureDate;
		this.employeeID = employeeID;
		this.guestID = guestID;
	}

	//*****************************************************\\
	
	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public LocalDateTime getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDateTime dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public Integer getGuestID() {
		return guestID;
	}

	public void setGuestID(Integer guestID) {
		this.guestID = guestID;
	}

	//****************************************************\\
	
	@Override
	public String toString() {
		return "Reservation [reservationID=" + reservationID + ", time=" + time + ", dateOfArrival=" + dateOfArrival
				+ ", departureDate=" + departureDate + ", EmployeeID=" + employeeID + ", guestID=" + guestID + "]";
	}
	
}
