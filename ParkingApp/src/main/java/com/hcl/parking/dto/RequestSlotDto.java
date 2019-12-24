package com.hcl.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;


public class RequestSlotDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer regId;
	private LocalDate date;
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
