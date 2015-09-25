package com.service.customuserdetailsservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.group.Group;
import com.model.user.User;
import com.service.userservice.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUsername(userName);
		
		if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	
	//liste aller Rechte die der Benutzer hat
	private List<GrantedAuthority> getAuthorities(User user)
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Group groups : user.getGroups())
		{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+groups.getType()));
		}
		return authorities;
	}
}
