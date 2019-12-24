package com.hcl.parking.dto;

import java.io.Serializable;

public class SlotRequestDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String days;
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
