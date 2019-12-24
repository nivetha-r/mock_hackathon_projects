package com.hcl.store.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.dto.UserRequestDto;
import com.hcl.store.entity.User;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTests {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	@Test
	public void testFindUserByUserNameAndPassWordPositive() throws UserNotFoundException {
		User user=new User();
		user.setUserName("Nivi");
		user.setPassWord("Nisha");
		when(userRepository.findUserByUserNameAndPassWord("Nivi", "Nisha")).thenReturn(user);
		User response=userServiceImpl.findUserByUserNameAndPassWord("Nivi", "Nisha");
		assertEquals(user, response);
		
		
//		User user=new User();
//		user.setUserName("nivi");
//		user.setPassWord("nisha");
//		when(userRepository.findUserByUserNameAndPassWord("nivi", "mnhb")).thenReturn(user);
//		User response=userServiceImpl.findUserByUserNameAndPassWord("nivi", "hhg");
//		assertEquals("User not Available", response);
		
	}

	@Test(expected = UserNotFoundException.class)
	public void testFindUserByUserNameAndPassWordNegative() throws UserNotFoundException {
		User user = new User();
		user.setPassWord("nisha1");
		user.setUserName("Nisha");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("nisha1", "Nisha")).thenReturn(null);
		user = userServiceImpl.findUserByUserNameAndPassWord("nisha1", "Nisha");
	}

	@Test
	public void testLoginUserPositive() {
		UserRequestDto userRequestDto = new UserRequestDto();
		User user = new User();
		userRequestDto.setUserName("Nivi");
		userRequestDto.setPassWord("nivi");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("Nivi", "nivi")).thenReturn(user);
		String result = userServiceImpl.loginUser(userRequestDto);
		assertEquals("Login Success", result);
	}

	@Test
	public void testLoginUserNegative() {
		UserRequestDto userRequestDto = new UserRequestDto();
		User user = new User();
		userRequestDto.setUserName("Nivi");
		userRequestDto.setPassWord("nivi");
		Mockito.when(userRepository.findUserByUserNameAndPassWord("nivi2", "nivi2")).thenReturn(user);
		String result = userServiceImpl.loginUser(userRequestDto);
		assertEquals("Login failed", result);
	}

}
