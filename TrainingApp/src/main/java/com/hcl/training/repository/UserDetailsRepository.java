package com.hcl.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.training.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
	
	public UserDetails findByUserName(String userName);

}
