package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.RegistrationRequestDto;
import com.hcl.parking.dto.RegistrationResponseDto;

@Service
public interface UserRegistrationService {

	public RegistrationResponseDto registerUser(RegistrationRequestDto userRegistrationRequestDto);
}
