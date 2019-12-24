package com.hcl.store.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="productstore")
@Getter
@Setter
public class ProductStore {
	
	@Id
	private Integer id;
	private Integer productId;
	private String productName;
	private Integer storeId;
	private double price;
	
	 

}
