package com.hcl.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.entity.ProductStore;

@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Integer> {
	
	//ProductStore findByProductId(String productName);

	public ProductStore findBystoreId(Integer storeId);

	public List<ProductStore> findByProductName(String productName);

	public ProductStore findByProductId(Integer productId);

	//List<ProductStore> findByProductName(String productName);

}
