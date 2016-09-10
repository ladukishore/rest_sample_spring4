package com.lkd.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lkd.spring.dao.UserDAO;
import com.lkd.spring.model.User;

@RestController
public class UserRestController {

	
	@Autowired
	private UserDAO userDAO;

	
	@GetMapping("/users")
	public List getUsers() {
		return userDAO.list();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity getUser(@PathVariable("id") Long id) {

		User user = userDAO.get(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping(value = "/users")
	public ResponseEntity createUser(@RequestBody User user) {

		userDAO.create(user);

		return new ResponseEntity(user, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {

		if (null == userDAO.delete(id)) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/users/{id}")
	public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {

		user = userDAO.update(id, user);

		if (null == user) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(user, HttpStatus.OK);
	}

}
