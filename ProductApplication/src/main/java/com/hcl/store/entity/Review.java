package com.hcl.store.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="review")
@Getter
@Setter
public class Review {
	
	@Id
	private Integer reviewId;
	private Integer userId;
	private Integer storeId;
	private Integer rating;

}
	