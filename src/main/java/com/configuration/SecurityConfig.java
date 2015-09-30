package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .httpBasic().and()
	      .authorizeRequests()
	      	.antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.POST, "/admin/").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PUT, "/admin/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PATCH, "/admin/**").hasRole("ADMIN").and()
	      .csrf().disable();
	}
	*/
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()                                                                                
			.antMatchers("/admin/**").hasRole("ADMIN")       							// darf nur der Admin
			.antMatchers("/data/**").access("hasRole('ADMIN') or hasRole('USER')")     // Admin und User
			.and().formLogin().loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/Access_Denied"); // noch nicht implementiert
	}
	/*
	only http Security
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.and()
		.httpBasic();
	}*/
}

/*
 * The configuration creates a Servlet Filter known as the springSecurityFilterChain which is responsible 
 * for all the security (protecting the application URLs, validating submitted username and passwords,
 *  redirecting to the log in form, etc) within your application.
 */

