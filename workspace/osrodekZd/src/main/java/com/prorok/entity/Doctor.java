package com.prorok.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.prorok.enums.Role;

@Entity
public class Doctor extends BasePerson {

	private String specialty;
	
	@Embedded
	private WorkingHours workingHours;

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Doctor() {
	 setRole(Role.DOCTOR);
	}
	
	
}
