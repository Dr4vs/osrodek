package com.prorok.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.prorok.enums.Status;

@Entity
public class Visit extends Base{
	
	@NotNull
	private Date date;
	
	@NotNull
	@ManyToOne
	private Doctor doctor;
	
	@NotNull
	@ManyToOne
	private Person person;
	
	private String description;
	
	@NotNull
	private Status status;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Visit() {
		this.status = Status.SAVED;
	}
}
