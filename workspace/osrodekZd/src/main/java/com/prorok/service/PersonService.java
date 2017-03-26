package com.prorok.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.prorok.entity.Person;

public interface PersonService extends UserDetailsService{

	List<Person> findAll();
	Person findOne(Long id);
	void save(Person person);
	void delete(Long id);
	Person findByEmail(String email);
}
