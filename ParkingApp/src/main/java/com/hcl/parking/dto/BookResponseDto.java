package com.hcl.parking.dto;

import java.io.Serializable;

public class BookResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;

	private String slotId;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
