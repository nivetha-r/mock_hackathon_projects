package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.hcl.parking.constants.ParkingConstants;
import com.hcl.parking.dto.RegistrationRequestDto;
import com.hcl.parking.dto.RegistrationResponseDto;
import com.hcl.parking.entity.Registration;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.exceptions.UserNotFoundException;
import com.hcl.parking.repository.RegistrationRepository;
import com.hcl.parking.repository.SlotRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	SlotRepository slotRepository;

	@Override
	public RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto) {
		RegistrationResponseDto response = new RegistrationResponseDto();
		Registration register = new Registration();
		Optional<Registration> registration = registrationRepository
				.findByUserName(registrationRequestDto.getUserName());
		if (registration.isPresent()) {
			throw new UserNotFoundException(ParkingConstants.USER_ALREADY_REGISTERED);
		}
		if (registrationRequestDto.getExperience() >= 15) {
			register.setUserName(registrationRequestDto.getUserName());
			register.setPassword(registrationRequestDto.getPassword());
			register.setMobileNo(registrationRequestDto.getMobileNo());
			register.setExperience(registrationRequestDto.getExperience());
			register.setEmpId(1);
		} else {
			register.setUserName(registrationRequestDto.getUserName());
			register.setPassword(registrationRequestDto.getPassword());
			register.setMobileNo(registrationRequestDto.getMobileNo());
			register.setExperience(registrationRequestDto.getExperience());
			register.setEmpId(2);
		}
		Registration reg = registrationRepository.save(register);
		if (registrationRequestDto.getExperience() >= 15) {
			Slot slot = new Slot();
			slot.setSlotName("S" + reg.getRegistrationId());
			slot.setRegistrationId(reg.getRegistrationId());
			slotRepository.save(slot);
		}
		response.setMessage("User registered successfully");
		return response;
	}

}
