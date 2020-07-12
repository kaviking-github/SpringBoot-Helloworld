package com.boot1.kavi.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import User.UserDetails;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, path="/hello")
	public String helloworld() {
		return "Hello World1";
	}
	
	@GetMapping("/getUserDetails")
	public UserDetails getUserDetails() {
		return new UserDetails("Kavi", "king", "Theni");
	}
}
