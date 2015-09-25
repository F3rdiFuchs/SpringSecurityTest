package com.service.userservice;

import com.model.user.User;

public interface UserService {
	User findById(int id);
	User findByUsername(String username);
}
