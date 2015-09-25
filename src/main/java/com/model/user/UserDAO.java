package com.model.user;

public interface UserDAO {
	User findById(int id);
	User findByUsername(String username);
}
