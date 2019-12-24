package com.hcl.parking.dto;

import java.time.LocalDate;


public class RequestSlotDto {
	private Integer registrationId;
	private LocalDate date;
	
	public Integer getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	

}
