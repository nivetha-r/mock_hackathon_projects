package com.hcl.shop.entity;

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
	private Long productStoreId;
	private String storeName;
	private String productName;
	private String productPrice;
	private Integer productQuantity;

}
