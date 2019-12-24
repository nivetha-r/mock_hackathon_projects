package com.hcl.training.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.entity.Account;
import com.hcl.training.dto.LoginDto;
import com.hcl.training.dto.ResponseDto;
import com.hcl.training.entity.CourseList;
import com.hcl.training.entity.UserDetails;
import com.hcl.training.exception.InvalidCredentials;
import com.hcl.training.exception.UserNotFound;
import com.hcl.training.repository.CourseListRepository;
import com.hcl.training.repository.UserDetailsRepository;


@Service
public class UserLoginServiceImpl implements UserLoginService {

	private final Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	@Autowired
	UserDetailsRepository userDetailsRepository;

	

	@Override
	public ResponseDto userLogin(LoginDto loginDto) {

		logger.info("LoginData:" + loginDto.getUserName() + "Password:" + loginDto.getPassword());

		List<CourseList> courselist = null;
		CourseList course = null;
		int userId = 0;

        
		String userName = loginDto.getUserName();
		String password = loginDto.getPassword();

		UserDetails userDetails= userDetailsRepository.findByUserName(userName);

		if (userDetails != null) {

			if ((userDetails.getUserName().equals(userName) && userDetails.getPassword().equals(password))) {

				userId = userDetails.getUserId();

				courselist = CourseListRepository.findBycourseId(userDetails);
				ResponseDto responseDto = new ResponseDto();
				course = courselist.get(0);
				responseDto.setAccNo(course.getuserName());
				responseDto.setMessage("Logined successfully");
				responseDto.setUserName(userName);

				return responseDto;

			}

			else {
				throw new InvalidCredentials("Enter correct username or password");
			}
		} else {
			throw new UserNotFound("User not found");
		}

	}

	@Override
	public ResponseDto userLogin(LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
