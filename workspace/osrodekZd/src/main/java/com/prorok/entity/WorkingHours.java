package com.prorok.entity;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class WorkingHours {

	private Time startworkingHours;
	private Time endworkingHours;
	
	@Column
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = DayOfWeek.class)
	private List<DayOfWeek> daysOfWeek;

	public Time getStartworkingHours() {
		return startworkingHours;
	}

	public void setStartworkingHours(Time startworkingHours) {
		this.startworkingHours = startworkingHours;
	}

	public Time getEndworkingHours() {
		return endworkingHours;
	}

	public void setEndworkingHours(Time endworkingHours) {
		this.endworkingHours = endworkingHours;
	}

	public List<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}
}
