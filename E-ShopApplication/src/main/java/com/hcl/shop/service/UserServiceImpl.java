package com.hcl.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.shop.entity.User;
import com.hcl.shop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public Optional<User> loginUser(String userName, String password) {
		return userRepository.findByUserNameAndPassword(userName,password);
	}

}
