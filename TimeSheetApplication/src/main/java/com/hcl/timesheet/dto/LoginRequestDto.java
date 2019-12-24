package com.hcl.timesheet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
	
	private String employeeName;
	private String passWord;

}
