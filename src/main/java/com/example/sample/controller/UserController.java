package com.example.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.Entity.User;
import com.example.sample.Entity.UserCredentials;
import com.example.sample.Entity.UserDetails;
import com.example.sample.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean saveUserInfo(@RequestBody User user) {

		User userDetails = userService.saveUserDetails(user);

		if (userDetails != null) {
			return true;
		}
		return false;

	}

	@RequestMapping(path = "/check", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean checkUserInfo(@RequestBody UserCredentials credentials) {
		UserDetails userDetails = userService.checkUserCredentials(credentials);
		if (userDetails == null) {
			return false;
		}
		if (userDetails.getUserName().equals(credentials.getUserName())
				&& userDetails.getPassword().equals(credentials.getPassword())) {
			return true;
		}
		return false;
	}

	@RequestMapping(path = "/getUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserInfo(@RequestBody UserCredentials userCredentials) {
		return userService.getUserDetails(userCredentials);
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUserInfo(@RequestBody User user) {
		
		logger.info("UserID:"+user.getId());
		
		System.out.println(user);
		
		User userDetails = userService.updateUserDetails(user);

		// if (userDetails != null) {
		// return true;
		// }
		return userDetails;
	}

}
