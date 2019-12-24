package com.ticketbooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Place {
	@Id
	private Integer placeId;
	private String placeName;
	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
