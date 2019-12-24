package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.LoginDto;
import com.hcl.parking.dto.LoginResponseDto;
import com.hcl.parking.service.LoginService;

@RestController
@RequestMapping("")
public class LoginController {
	@Autowired 
	LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto){
		return new ResponseEntity<>(loginService.loginUser(loginDto), HttpStatus.OK);
	}
}