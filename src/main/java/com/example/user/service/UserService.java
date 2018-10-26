package com.example.user.service;

import com.example.user.model.User;

public interface UserService {
	
	User findById(long id);
	
	User findByName(String name);
	
	User save(User user);
	
	User update(User user);
	
	void deleteById(long id);

	Iterable<User> findAllUsers();
	
}
