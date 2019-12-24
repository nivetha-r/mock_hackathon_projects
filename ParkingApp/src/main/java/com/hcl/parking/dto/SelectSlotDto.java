package com.hcl.parking.dto;

import java.io.Serializable;


public class SelectSlotDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer availslotId;

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
