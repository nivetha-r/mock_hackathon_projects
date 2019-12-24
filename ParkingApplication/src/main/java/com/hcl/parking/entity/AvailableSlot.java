package com.hcl.parking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="availableslot")
public class AvailableSlot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer availableslotId;
	private LocalDate availableDate;
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
	public LocalDate getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(LocalDate availableDate) {
		this.availableDate = availableDate;
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
