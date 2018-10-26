package com.example.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.user.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByName(String name);
	
}
