package com.hcl.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public static void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
