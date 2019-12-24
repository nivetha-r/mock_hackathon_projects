package com.hcl.parking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requestslot")
public class RequestSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer requestSlotId;
	private LocalDate requestDate;
	private Integer registrationId;
	public Integer getRequestSlotId() {
		return requestSlotId;
	}
	public void setRequestSlotId(Integer requestSlotId) {
		this.requestSlotId = requestSlotId;
	}
	public LocalDate getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}
	public Integer getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	
}
