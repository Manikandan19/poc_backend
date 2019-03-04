package com.example.sample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.Entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	User findById(int id);
}
