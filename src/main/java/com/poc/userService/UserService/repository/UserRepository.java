package com.poc.userService.UserService.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.poc.userService.UserService.model.User;

public interface UserRepository extends ListCrudRepository<User, Long> {
	
	

}
