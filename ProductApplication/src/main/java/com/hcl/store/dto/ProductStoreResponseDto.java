package com.hcl.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStoreResponseDto {
	
	private String productName;
	private Integer storeId;	
	private double price;
	private Integer rating;


}
