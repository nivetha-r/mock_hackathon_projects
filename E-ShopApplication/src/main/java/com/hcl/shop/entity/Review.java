package com.hcl.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {
	@Id
	private Long reviewId;
	private String storeId;
	private String storeName;
	private double ratings;

}
