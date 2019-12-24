package com.hcl.store.service;

import org.springframework.stereotype.Service;

import com.hcl.store.dto.UserRequestDto;
import com.hcl.store.entity.User;
import com.hcl.store.exception.UserNotFoundException;

@Service
public interface UserService {
	
    User findUserByUserNameAndPassWord(String userName,String passWord) throws UserNotFoundException;
	
	 public String loginUser(UserRequestDto userRequestDto);

}
