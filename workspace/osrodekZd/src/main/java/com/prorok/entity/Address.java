package com.prorok.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address{
	
	
	private String zipCode;
	
	private String city;
	
	private String street;
	
	@Column(nullable = true)
	private int houseNumber;
	
	@Column(nullable = true)
	private int localNumber;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(int localNumber) {
		this.localNumber = localNumber;
	}
}
