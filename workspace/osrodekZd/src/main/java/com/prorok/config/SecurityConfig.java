package com.prorok.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prorok.service.PersonService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final int ENCODE_STRENGTH = 10; 
	
	@Autowired
	private PersonService personService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(ENCODE_STRENGTH);
		authenticationManagerBuilder.userDetailsService(personService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/resources/**")
	        .antMatchers("/");
	}
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()  
	                    .antMatchers("/login").permitAll()
	                    .antMatchers("/register").permitAll()
	                    .antMatchers("/users/**", "/create-user").hasRole("ADMIN")
	                    .antMatchers("/admin/**").hasRole("ADMIN")
	                    .antMatchers("/api/**").permitAll()
	                    .anyRequest().authenticated()
	                .and()   
	                .formLogin()           
	                    .usernameParameter("email")
	                    .passwordParameter("password")
	                    .loginPage("/login")
	                    .loginProcessingUrl("/login")
	                    .defaultSuccessUrl("/")
	                    .failureUrl("/login.html?error=true")
	                .and()
	                .logout()
	                    .logoutUrl("/logout")
	                    .logoutSuccessUrl("/login?logout")
	                .and()
	                .csrf().disable(); 	
	}
}
