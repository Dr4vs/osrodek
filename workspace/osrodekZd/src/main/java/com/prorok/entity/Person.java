package com.prorok.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.prorok.enums.Role;

@Entity
public class Person extends BasePerson{

	@Column(nullable = true)
	private boolean allergic;
	
	private String allergicDescription;

	public boolean isAllergic() {
		return allergic;
	}

	public void setAllergic(boolean allergic) {
		this.allergic = allergic;
	}

	public String getAllergicDescription() {
		return allergicDescription;
	}

	public void setAllergicDescription(String allergicDescription) {
		this.allergicDescription = allergicDescription;
	}
	
	public Person(String firstname,String lastname,String email,String password, Role role){
		super(firstname,lastname,email,password,role);
	}
	
	public Person(){
		
	}
}
