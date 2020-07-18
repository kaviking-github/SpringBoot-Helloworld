package com.boot1.kavi.User.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot1.kavi.User.Entities.User;
import com.boot1.kavi.User.Services.UserService;

//RestController - users
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public boolean deleteUserById(@PathVariable("id") Long id) {
		return userService.deleteUserById(id);
	}
	
	@GetMapping("/getUserByName/{username}")
	public User getUserByUserName(@PathVariable("username") String userName) {
		return userService.getUserByName(userName);
	}
}
