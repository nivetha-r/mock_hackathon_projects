package com.hcl.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.entity.User;
import com.hcl.training.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	 
	@Autowired
	UserService userService;
	
	@PostMapping("reg")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		 String result=userService.saveUser(user);
		 return new ResponseEntity<String>(result,HttpStatus.CREATED);
		 
	 }

}
