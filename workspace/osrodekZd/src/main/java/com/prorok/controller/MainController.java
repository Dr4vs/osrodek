package com.prorok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prorok.config.SecurityConfig;
import com.prorok.entity.Person;
import com.prorok.service.EmailService;
import com.prorok.service.PersonService;

@Controller
public class MainController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private EmailService emailService;
	

	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public String getMainPage(){
		return "main";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegisterPage(){
		return "register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute	Person person){
		try{
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder(SecurityConfig.ENCODE_STRENGTH);
			String encodedPassword = bc.encode(person.getPassword());
			person.setPassword(encodedPassword);
			personService.save(person);
		} catch(Exception ex){
			return "register";
		}
		emailService.sendEmail("osrodekzdrowiatest@gmail.com",person.getEmail(),"Ośrodek Zdrowia","Witaj "+person.getFirstName()+", na stronie ośrodka zdrowia. Skonfiguruj w pełni sowje konto by móc korzystać, ze wszystkich możliwości serwisu");
		
		return "login";
	}
}
