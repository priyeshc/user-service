package com.poc.userService.UserService.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.userService.UserService.model.User;
import com.poc.userService.UserService.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public List<User> getallUsers() {
		return userService.getallUsers();
	}

	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {

		userService.saveUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {

		userService.deleteUser(id);

		return ResponseEntity.ok("User deleted successfully");

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long id) {

		userService.updateUser(id, user);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User Updated Successfully");

	}

}
