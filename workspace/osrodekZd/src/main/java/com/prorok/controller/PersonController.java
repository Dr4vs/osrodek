package com.prorok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prorok.entity.Person;
import com.prorok.enums.Role;
import com.prorok.service.PersonService;

@Controller
public class PersonController {
	//add person by admin
	//edit person
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value="/persons")
	public String getUserList(Model model){
		List<Person> persons = personService.findAll();
		model.addAttribute("personList",persons);
		return "persons";
	}
	
	@RequestMapping(value="/create-person",method = RequestMethod.GET)
	public String createPerson(){
		return "person-create";
	}
	
	@RequestMapping(value="/create-person",method = RequestMethod.POST)
	public String savePerson(
			@RequestParam(required=false)Long id,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam Role role)
	{
		Person person = new Person(firstName,lastName,email,password,role);
		personService.save(person);
		return "redirect:/persons";
	}
	
	@RequestMapping(value="/persons/delete/{id}")
	public String deleteUser(@PathVariable Long id){
		personService.delete(id);
		return "persons";
	}
	
	@RequestMapping(value="/persons/edit/{id}")
	public String editUser(@PathVariable Long id,Model model){
		Person person = personService.findOne(id);
		model.addAttribute(person);
		return "person-create";
	}

}
