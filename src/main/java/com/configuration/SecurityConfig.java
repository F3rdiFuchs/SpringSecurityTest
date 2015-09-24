package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER").and()
			.withUser("admin").password("password").roles("USER", "ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()                                                                                
			.antMatchers("/admin/**").hasRole("ADMIN")       //7 darf nur der Admin                                          					 // alle andere darf besucht werden   
			.and().formLogin().loginPage("/login")
			.usernameParameter("userName").passwordParameter("passWord")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
	
}

/*
 * The configuration creates a Servlet Filter known as the springSecurityFilterChain which is responsible 
 * for all the security (protecting the application URLs, validating submitted username and passwords,
 *  redirecting to the log in form, etc) within your application.
 */

