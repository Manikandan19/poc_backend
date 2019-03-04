package com.example.sample.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.Entity.Address;

@Transactional
public interface AddressRepository extends JpaRepository<Address,Integer> {
	
	Address findByAddressID(int addressID);

}
