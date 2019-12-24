package com.hcl.store.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.dto.UserRequestDto;
import com.hcl.store.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTests {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	
	@Test
	public void testLoginUserPositive() {
		UserRequestDto userRequestDto=new UserRequestDto();
		
		
		userRequestDto.setPassWord("nivi");
		userRequestDto.setUserName("Nivi");
		
		String message="Login Success";
		Mockito.when(userService.loginUser(userRequestDto)).thenReturn(message);
		int result=userController.loginUser(userRequestDto).getStatusCodeValue();
		assertEquals(200, result);
	}
	
	@Test
	public void testLoginUserNegative() {
		UserRequestDto userRequestDto=new UserRequestDto();
		
		String message="Login failed";
		Mockito.when(userService.loginUser(userRequestDto)).thenReturn(message);
		int result=userController.loginUser(userRequestDto).getStatusCodeValue();
		assertEquals(404, result);
	}
	}
