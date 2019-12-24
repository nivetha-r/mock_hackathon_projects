package com.hcl.training.service;

import org.springframework.stereotype.Service;

import com.hcl.training.dto.LoginDto;
import com.hcl.training.dto.ResponseDto;



@Service
public interface UserLoginService {

	public ResponseDto userLogin(LoginDto loginDto);

}
