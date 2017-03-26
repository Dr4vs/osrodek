package com.prorok.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prorok.dao.PersonDao;
import com.prorok.entity.Person;


@Service
public class PersonServiceImpl implements PersonService {

		@Autowired
		private PersonDao personDao;
		
		
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			Person person = personDao.findByEmail(email);
			if(person==null){
				throw new UsernameNotFoundException(String.format("Uzytkownik z emailem %s nie istnieje", email));				
			}
			
			List<GrantedAuthority> authorities = new  ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + person.getRole()));
				
			return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPassword(), authorities);		
		}

	
		@Override
		public List<Person> findAll() {	
			return personDao.findAll();
		}


		@Override
		public Person findOne(Long id) {
		
			return personDao.findOne(id);
		}


		@Override
		public void save(Person person) {
			personDao.save(person);
			
		}

		@Override
		public void delete(Long id) {
			personDao.delete(id);
			
		}

		@Override
		public Person findByEmail(String email) {
		return personDao.findByEmail(email);
			
		}
}
