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
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentID")
	private Integer paymentID;
	
	@Column(name = "Amount")
	private Integer amount;
	
	@Column(name = "Method")
	private String method;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "Time")
	private LocalDateTime time;
	
	@Column(name = "CurrencyUnit")
	private String currencyUnit;
	
	@Column(name = "TransactionID")
	private String transactionID;
	
	@Column(name = "ReservationID")
	private Long reservationID;

	//*******************************************************\\
	
	public Payment() {

	}

	public Payment(Integer amount, String method, String status, LocalDateTime time,
			String currencyUnit, String transactionID, Long reservationID) {
		this.amount = amount;
		this.method = method;
		this.status = status;
		this.time = time;
		this.currencyUnit = currencyUnit;
		this.transactionID = transactionID;
		this.reservationID = reservationID;
	}

	//*******************************************************\\
	
	public Integer getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Integer paymentID) {
		this.paymentID = paymentID;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(String currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public Long getReservationID() {
		return reservationID;
	}

	public void setReservationID(Long reservationID) {
		this.reservationID = reservationID;
	}

	//*******************************************************\\
	
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", amount=" + amount + ", method=" + method + ", status=" + status
				+ ", time=" + time + ", currencyUnit=" + currencyUnit + ", transactionID=" + transactionID
				+ ", reservationID=" + reservationID + "]";
	}
}
