package com.hcl.parking.dto;

import java.io.Serializable;


public class LoginResponseDto implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	private Integer regId;
	private String message;
	private String empName;
	
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
