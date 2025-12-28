package com.matinsoft.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GuestID")
	private Integer guestID;

	@Column(name = "NationalCode")
	private String nationalCode;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Country")
	private String country;

	@Column(name = "DateOfBirth")
	private LocalDate dateOfBirth;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "EmailAddress")
	private String emailAddress;

	@Column(name = "EmployeeID")
	private Integer employeeID;

	//***********************************************************\\

	public Guest() {

	}

	public Guest(String nationalCode, String firstName, String lastName, String country,
			LocalDate dateOfBirth, String phoneNumber, String emailAddress, Integer employeeID) {
		this.nationalCode = nationalCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.employeeID=employeeID;
	}

	//***********************************************************\\

	public Integer getGuestID() {
		return guestID;
	}

	public void setGuestID(Integer guestID) {
		this.guestID = guestID;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	//***********************************************************\\

	@Override
	public String toString() {
		return "Guest [guestID=" + guestID + ", nationalCode=" + nationalCode + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", country=" + country + ", dateOfBirth=" + dateOfBirth + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", employeeID=" + employeeID + "]";
	}



}