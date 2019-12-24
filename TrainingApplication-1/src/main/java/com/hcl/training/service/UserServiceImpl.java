package com.hcl.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.entity.User;
import com.hcl.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public String saveUser(User user) {
		userRepository.save(user);
		return "success";
	}

	
}
