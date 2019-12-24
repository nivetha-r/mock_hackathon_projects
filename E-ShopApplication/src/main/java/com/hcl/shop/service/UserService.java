package com.hcl.shop.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.shop.entity.User;

@Service
public interface UserService {

	public Optional<User> loginUser(String userName, String password);

}
