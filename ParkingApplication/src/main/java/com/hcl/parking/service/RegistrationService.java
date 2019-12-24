package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.RegistrationRequestDto;
import com.hcl.parking.dto.RegistrationResponseDto;

@Service
public interface RegistrationService {

	public RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto);

}
