package com.hcl.store.service;

import java.util.List;

import com.hcl.store.entity.Product;

public interface ProductService {
	
	Product saveProduct(String productName);

	List<Product> findProductByProductName(String productName);
	

}
