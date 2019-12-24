package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.RegistrationRequestDto;
import com.hcl.parking.dto.RegistrationResponseDto;
import com.hcl.parking.service.RegistrationService;

@RestController
@RequestMapping("")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;

	@PostMapping("/register")
	public ResponseEntity<RegistrationResponseDto> registerUser(@RequestBody RegistrationRequestDto registrationRequestDto ){
		RegistrationResponseDto response=registrationService.registerUser(registrationRequestDto);
		return new ResponseEntity<>(response,HttpStatus.CREATED);

		
	}
}
//@Autowired
//UserRegistrationServiceImpl userRegistrationServiceImpl;
//
///**
// * This method is intended to register user and provide a slot for user
// * 
// * @param UserRegistrationRequestDto is the input object which includes
// *                          password,mobileNumber,overAllExperience
// *                          userName, hclExperience;
// * @exception USER_ALREADY_REGISTERED,INVALID_MOBILENUMBER,INVALID_NAME
// * @return UserRegistrationResponseDto which returns message
// */
//@PostMapping("/register")
//public ResponseEntity<UserRegistrationResponseDto> registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
//	LOGGER.info("in register user controller");
//	UserRegistrationResponseDto response = userRegistrationServiceImpl.registerUser(userRegistrationRequestDto);
//	return new ResponseEntity<>(response, HttpStatus.CREATED);
//}