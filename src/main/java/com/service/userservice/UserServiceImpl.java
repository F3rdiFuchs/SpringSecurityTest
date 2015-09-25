package com.service.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.user.User;
import com.model.user.UserDAO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public User findById(int userId) {
		return this.userDAO.findById(userId);
	}

	public User findByUsername(String userName) {
		return this.userDAO.findByUsername(userName);
	}
}
