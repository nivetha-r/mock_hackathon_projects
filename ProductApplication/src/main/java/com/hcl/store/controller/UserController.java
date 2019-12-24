package com.hcl.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.store.dto.UserRequestDto;
import com.hcl.store.service.UserService;
/**
 * 
 * @author Nivetha
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	/**
	 * 
	 * @param userRequestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> loginUser(@RequestBody UserRequestDto userRequestDto) {
		String user=userService.loginUser(userRequestDto);
		if (user.equals("Login Success")) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
		}
	
		
	}
}
