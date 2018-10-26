package com.example.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name).get();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

}
