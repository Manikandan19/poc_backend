package com.example.sample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.Entity.User;
import com.example.sample.Entity.UserCredentials;
import com.example.sample.Entity.UserDetails;
import com.example.sample.controller.UserController;
import com.example.sample.repository.AddressRepository;
import com.example.sample.repository.UserDetailsRepository;
import com.example.sample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserDetailsRepository detailsRepository;

	@Autowired
	private AddressRepository addressRepository;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	public User saveUserDetails(User user) {
		User userDetails = null;
		List<UserDetails> details = detailsRepository.findByUserName(user.getDetails().getUserName());
		if (details.size() > 0) {
			return userDetails;
		} else {
			detailsRepository.save(user.getDetails());
			addressRepository.save(user.getAddress());
			userDetails = repository.save(user);
			return userDetails;
		}
	}

	public UserDetails checkUserCredentials(UserCredentials credentials) {
		UserDetails userDetails = detailsRepository.findByUserNameAndPassword(credentials.getUserName(),
				credentials.getPassword());
		return userDetails;
	}

	public User getUserDetails(UserCredentials userCredentials) {
		User user = new User();
		user.setDetails(detailsRepository.findByuserName(userCredentials.getUserName()));
		user.setAddress(addressRepository.findByAddressID(user.getDetails().getUserId()));
		return user;
	}

	public User updateUserDetails(User user) {

		User userDetails = null;
		detailsRepository.save(user.getDetails());
		addressRepository.save(user.getAddress());
		userDetails = repository.save(user);
		return userDetails;
	}

}
