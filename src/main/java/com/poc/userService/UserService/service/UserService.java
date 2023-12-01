package com.poc.userService.UserService.service;

import java.util.List;

//import com.poc.userService.UserService.model.Contact;
import com.poc.userService.UserService.model.User;

public interface UserService {
	
	void saveUser(User user);
	
	void deleteUser(Long id);

	void publishUserRegisteredEvent(User user);

	void publishUserDeletedEvent(Long id);
	
	List<User> getallUsers();
	
	void updateUser(Long id, User user );
	

	


}
