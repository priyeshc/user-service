package com.poc.userService.UserService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//import com.poc.userService.UserService.model.Contact;
import com.poc.userService.UserService.model.User;
import com.poc.userService.UserService.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveUser(User user) {

		User savedUser = userRepository.save(user);

		publishUserRegisteredEvent(savedUser);

	}

	@Override
	public void deleteUser(Long id) {

		userRepository.deleteById(id);

		publishUserDeletedEvent(id);

	}

	@Override
	public void publishUserRegisteredEvent(User user) {

		// User savedUser = userRepository.save(user);
		kafkaTemplate.send("users", "userRegistered: " + user.getId() + ". Sending Welcome Mail");

	}

	@Override
	public void publishUserDeletedEvent(Long id) {

		kafkaTemplate.send("users", "userDeleted: " + id);

	}

	@Override
	public List<User> getallUsers() {

		return userRepository.findAll();

	}

	@Override
	public void updateUser(Long id, User user) {

		if (!userRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
		}

		Optional<User> existingUserOptional = userRepository.findById(id);

		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			existingUser.setName(user.getName());
			existingUser.setEmailId(user.getEmailId());

			userRepository.save(existingUser);

		}

	}

}
