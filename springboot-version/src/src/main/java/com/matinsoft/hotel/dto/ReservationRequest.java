package com.matinsoft.hotel.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationRequest {

	private Long reservationID; //Just update
	private List<Integer> roomIds;
	private Integer guestId;
	private LocalDateTime dateOfArrival;
	private LocalDateTime departureDate;

	public ReservationRequest(Long reservationID, List<Integer> roomIds, Integer guestId, LocalDateTime dateOfArrival,
			LocalDateTime departureDate) {
		this.reservationID=reservationID;
		this.roomIds = roomIds;
		this.guestId = guestId;
		this.dateOfArrival = dateOfArrival;
		this.departureDate = departureDate;
	}

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	public List<Integer> getRoomIds() {
		return roomIds;
	}

	public void setRoomIds(List<Integer> roomIds) {
		this.roomIds = roomIds;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
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
}