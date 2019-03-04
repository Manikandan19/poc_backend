package com.example.sample.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.Entity.UserDetails;

@Transactional
public interface UserDetailsRepository  extends JpaRepository<UserDetails, Integer>{

	
	UserDetails findByUserNameAndPassword(String userName,String password);
	
	List<UserDetails> findByUserName(String userName);
	
	UserDetails findByuserName(String userName);
}
