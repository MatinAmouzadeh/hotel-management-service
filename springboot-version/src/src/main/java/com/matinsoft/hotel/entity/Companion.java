package com.matinsoft.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Companion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompanionID")
	private Long companionID;

	@Column(name = "GuestID")
	private Integer guestID;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "NationalCode")
	private String nationalCode;

	@Column(name = "Country")
	private String country;

	//**********************************************\\

	public Companion() {

	}

	public Companion(Integer guestID, String firstName, String lastName, String country, String nationalCode) {
		this.guestID = guestID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.nationalCode = nationalCode;
	}

	//**********************************************\\

	public Long getCompanionID() {
		return companionID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCompanionID(Long companionID) {
		this.companionID = companionID;
	}

	public Integer getGuestID() {
		return guestID;
	}

	public void setGuestID(Integer guestID) {
		this.guestID = guestID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	//**********************************************\\

	@Override
	public String toString() {
		return "Companion [companionID=" + companionID + ", guestID=" + guestID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nationalCode=" + nationalCode + ", country=" + country + "]";
	}
}
