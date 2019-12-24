package com.hcl.parking.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ReleaseRequestDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer regId;
	private LocalDate fromDate;
	private LocalDate toDate;
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
