package com.hcl.parking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="remslots")
public class RemainingSlots implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer remainingslotId;
	private LocalDate date;
	private Integer slotId;
	private String status;
	private Integer managerId;
	private Integer parkedempId;
	public Integer getRemainingslotId() {
		return remainingslotId;
	}
	public void setRemainingslotId(Integer remainingslotId) {
		this.remainingslotId = remainingslotId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	
}
