package com.hcl.timesheet.service;

import java.util.List;

import com.hcl.timesheet.dto.LoginRequestDto;
import com.hcl.timesheet.dto.PlaceResponseDto;
import com.hcl.timesheet.entity.Employee;
import com.hcl.timesheet.exception.PlaceNotFoundException;

public interface EmployeeService {

	//public String loginUser(LoginRequestDto userRequestDto);

// List<Employee> findAll();

	//public List<PlaceResponseDto> getPlaceList(Integer placeId);

	//public List<Employee> getDetails(String productName);

	List<Employee> getDetails(Integer placeId) throws PlaceNotFoundException;

}
