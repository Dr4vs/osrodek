package com.prorok.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import com.prorok.enums.Role;

@Entity
public class Personel extends BasePerson{

	@Embedded
	private WorkingHours workingHours;

	public Personel() {
		setRole(Role.NURSE);
	}
}
