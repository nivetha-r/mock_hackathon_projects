package com.hcl.shop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.shop.dto.UserResponseDto;
import com.hcl.shop.entity.User;
import com.hcl.shop.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public ResponseEntity<UserResponseDto> loginUser(@RequestParam String userName,@RequestParam String password)
			throws UserNotFoudException{
		UserResponseDto userResponseDto=new UserResponseDto();
		Optional<User> users=userService.loginUser(userName,password);
		if(users.isPresent()) {
			userResponseDto.setStatusCode(200);
			userResponseDto.setMessage("Login success so you can buy now");
			return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
		}
		userResponseDto.setStatusCode(404);
		userResponseDto.setMessage("Wrong credentials");
		return new ResponseEntity<>(userResponseDto,HttpStatus.NOT_FOUND);
		

}
}
