package com.hcl.parking.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reqslot")
public class RequestSlot implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reqslotId;
	private LocalDate reqDate;
	private Integer regId;
	public Integer getReqslotId() {
		return reqslotId;
	}
	public void setReqslotId(Integer reqslotId) {
		this.reqslotId = reqslotId;
	}
	public LocalDate getReqDate() {
		return reqDate;
	}
	public void setReqDate(LocalDate reqDate) {
		this.reqDate = reqDate;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
