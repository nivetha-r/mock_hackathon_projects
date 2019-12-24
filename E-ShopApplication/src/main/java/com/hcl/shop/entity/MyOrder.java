package com.hcl.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="myorder")
@Getter
@Setter
public class MyOrder {
	@Id
	private Long orderId;
	private Long userId;
	private String storeName;
	private String productName;

}
