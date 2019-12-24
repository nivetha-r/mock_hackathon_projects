package com.hcl.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.timesheet.entity.Employee;
import com.hcl.timesheet.exception.PlaceNotFoundException;
import com.hcl.timesheet.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

//	@Override
//	public String loginUser(LoginRequestDto userRequestDto) {
//		
//		return null;
//	}

//	@Override
//	public List<Employee> getDetails(String productName) throws ProductNotFoundException {
//		List<Product> productDetails = productRepository.findAll();
//		productDetails = productDetails.stream()
//				.filter(product -> product.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
//				.collect(Collectors.toList());
//		if (productDetails.isEmpty()) {
//			throw new ProductNotFoundException("No products found");
//		}
//		return productDetails;
//
//	}

//@Override
//public List<PlaceResponseDto> getPlaceList(Integer placeId) throws ProductNotFoundException {
//	List<Employee> productDetails = employeeRepository.findAll();
////	productDetails = productDetails.stream()
////			.filter(product -> product.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
////			.collect(Collectors.toList());
//	if (productDetails.isEmpty()) {
//		throw new PlaceNotFoundException("No places found");
//	}
//	return productDetails;
//
//}

@Override
public List<Employee> getDetails(Integer employeeId) throws PlaceNotFoundException {
	List<Employee> productDetails = employeeRepository.findAll();
//	productDetails = productDetails.stream()
//			.filter(product -> product.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
//			.collect(Collectors.toList());
	if (productDetails.isEmpty()) {
		throw new PlaceNotFoundException("No places found");
	}
	return productDetails;

}
}



