package com.prorok.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prorok.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

	Person findByEmail(String email);
	
}