package com.matinsoft.hotel.dto;

import java.util.List;

public class ReservationResponse {

	private String message;
    private Long reservationId;
    private String status;
    private Integer totalPrice;
    private List<Integer> reservedRoomIds;

	public ReservationResponse(String message, Long reservationId, String status, Integer totalPrice,
			List<Integer> reservedRoomIds) {
		this.message = message;
		this.reservationId = reservationId;
		this.status = status;
		this.totalPrice = totalPrice;
		this.reservedRoomIds = reservedRoomIds;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Integer> getReservedRoomIds() {
		return reservedRoomIds;
	}
	public void setReservedRoomIds(List<Integer> reservedRoomIds) {
		this.reservedRoomIds = reservedRoomIds;
	}
}
