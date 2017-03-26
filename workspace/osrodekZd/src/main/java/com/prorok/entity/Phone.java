package com.prorok.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone{

	@Column(nullable = true)
	private int phone;

	private String type;


	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
