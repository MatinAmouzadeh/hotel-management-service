package com.matinsoft.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoomID")
	private Integer roomID;

	@Column(name="Status")
	private String status;

	@Column(name="NightlyPrice")
	private Integer nightlyPrice;

	@Column(name="Capacity")
	private int capacity;

	@Column(name="Type")
	private String type;

	@Column(name="ReservationID")
	private Long reservationID;

	//*******************************************************\\

	public Room() {

	}

	public Room(String status, int nightlyPrice, int capacity, String type, Long reservationID) {
		this.status = status;
		this.nightlyPrice = nightlyPrice;
		this.capacity = capacity;
		this.type = type;
		this.reservationID = reservationID;
	}

	//***********************************************************************************\\

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNightlyPrice() {
		return nightlyPrice;
	}

	public void setNightlyPrice(int nightlyPrice) {
		this.nightlyPrice = nightlyPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	//****************************************************\\

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", status=" + status + ", nightlyPrice=" + nightlyPrice + ", capacity="
				+ capacity + ", type=" + type + ", reservationID=" + reservationID + "]";
	}

}
