package com.hcl.parking.dto;

import java.io.Serializable;

public class BookRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer regId;
	private Integer availslotId;
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getAvailslotId() {
		return availslotId;
	}
	public void setAvailslotId(Integer availslotId) {
		this.availslotId = availslotId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
