package com.boot1.kavi.User.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot1.kavi.User.Entities.User;
import com.boot1.kavi.User.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	public boolean deleteUserById(Long id) {
		boolean returnFlag = false;
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			returnFlag = true;
		}
		return returnFlag;
	}
	
	public User getUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
