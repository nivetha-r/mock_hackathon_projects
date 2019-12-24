package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.hcl.parking.dto.LoginDto;
import com.hcl.parking.dto.LoginResponseDto;
import com.hcl.parking.entity.Employee;
import com.hcl.parking.entity.Registration;
import com.hcl.parking.exceptions.UserNotFoundException;
import com.hcl.parking.repository.EmployeeRepository;
import com.hcl.parking.repository.RegistrationRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public LoginResponseDto loginUser(LoginDto loginDto) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<Registration> registration = registrationRepository.findByUserName(loginDto.getUserName());
		if (!registration.isPresent())
			throw new UserNotFoundException("User Name not exists");
		Optional<Employee> employee = employeeRepository.findByEmpId(registration.get().getEmpId());
		if (!employee.isPresent())
			throw new UserNotFoundException("emp id not available");
		if (registration.get().getUserName().equalsIgnoreCase(loginDto.getUserName())
				&& registration.get().getPassword().equals(loginDto.getPassword())) {
			loginResponseDto.setMessage("Login successful");
			loginResponseDto.setRegistrationId(registration.get().getRegistrationId());
		}
		return loginResponseDto;
	}

}
