package com.hcl.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="store")
@Getter
@Setter
@SequenceGenerator(name="storesequence",initialValue = 101,allocationSize = 1)
public class Store {
	@Id
	private Long storeId;
	private String storeName;
	private String storeLocation;
	private String storeContactNumber;

}
