package com.example.user.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/rest/api")
public class UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/users", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getAllUser() {
		logger.info("Fecthing all of Users...");
		List<User> users = (List<User>) userService.findAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> findById(@PathVariable long id) {
		logger.info("Fecthing user by id...");
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/byname/{name}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> findByName(@PathVariable String name) {
		logger.info("Fecthing user by name...");
		User user = userService.findByName(name);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value = "/users", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> save(@RequestBody User user){
		logger.info("Saving user...");
		User user_ = userService.save(user);
		return new ResponseEntity<User>(user_, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/users/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user){
		logger.info("Updating user...");
		User currentUser = userService.findById(id);
		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		return new ResponseEntity<User>(userService.save(currentUser), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/users/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> delete(@PathVariable long id){
		logger.info("Deleting user...");
		userService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
