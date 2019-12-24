package com.hcl.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.store.dto.UserRequestDto;
import com.hcl.store.entity.User;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserByUserNameAndPassWord(String userName, String passWord) throws UserNotFoundException {
		User user= userRepository.findUserByUserNameAndPassWord(userName, passWord);
		if(user==null) {
			throw new UserNotFoundException("User not Available");
		}
		 return user;
	}

	@Override
	public String loginUser(UserRequestDto userRequestDto) {
		User user = userRepository.findUserByUserNameAndPassWord(userRequestDto.getUserName(),
				userRequestDto.getPassWord());
		String result = null;
		if (user != null ) {
			result = "Login Success";

		} else {
			result = "Login failed";
		}

		return result;
	}
}
	

	
