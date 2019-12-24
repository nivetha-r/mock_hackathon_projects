package com.hcl.parking.dto;

import java.io.Serializable;

public class ReleaseResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
