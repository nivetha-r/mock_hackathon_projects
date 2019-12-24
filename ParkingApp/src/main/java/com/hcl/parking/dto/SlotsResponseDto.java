package com.hcl.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class SlotsResponseDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer availslotId;
	private LocalDate date;
	private Integer slotId;
	private String status;
	private Integer managerId;
	private Integer parkedempId;
	public Integer getAvailslotId() {
		return availslotId;
	}
	public void setAvailslotId(Integer availslotId) {
		this.availslotId = availslotId;
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
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public Integer getParkedempId() {
		return parkedempId;
	}
	public void setParkedempId(Integer parkedempId) {
		this.parkedempId = parkedempId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
