package com.hcl.parking.dto;

import java.time.LocalDate;

public class SlotsResponseDto {

	private Integer availableslotId;
	private LocalDate date;
	private Integer slotId;
	private String status;
	private Integer ownerId;
	private Integer bookedempId;
	public Integer getAvailableslotId() {
		return availableslotId;
	}
	public void setAvailableslotId(Integer availableslotId) {
		this.availableslotId = availableslotId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getSlotId() {
		return slotId;
	}
	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getBookedempId() {
		return bookedempId;
	}
	public void setBookedempId(Integer bookedempId) {
		this.bookedempId = bookedempId;
	}
	
}
