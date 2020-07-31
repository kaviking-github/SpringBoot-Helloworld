package com.boot1.kavi.User.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.boot1.kavi.User.Entities.User;
import com.boot1.kavi.User.Exception.UserExistsException;
import com.boot1.kavi.User.Exception.UserNotFoundException;
import com.boot1.kavi.User.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User user) throws UserExistsException {
		//if user Exists using username
		//if exists throw userExists exception
		User existingUser = userRepository.findByUserName(user.getUserName());
		if(existingUser != null) {
			throw new UserExistsException("User Already Exists");
		}
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found in Repository");
		}
		return user;
	}
	
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public boolean deleteUserById(Long id) {
		boolean returnFlag = false;
		if(!userRepository.findById(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in repository");
		}
		
		userRepository.deleteById(id);
		returnFlag = true;
		return returnFlag;
	}
	
	public User getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
