package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()                                                                                
			.antMatchers("/admin/**").hasRole("ADMIN")       							// darf nur der Admin
			.antMatchers("/data/**").access("hasRole('ADMIN') and hasRole('USER')")     // Admin und User
			.and().formLogin().loginPage("/login")
			.usernameParameter("userName").passwordParameter("passWord")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/Access_Denied"); // noch nicht implementiert
	}
}

/*
 * The configuration creates a Servlet Filter known as the springSecurityFilterChain which is responsible 
 * for all the security (protecting the application URLs, validating submitted username and passwords,
 *  redirecting to the log in form, etc) within your application.
 */

