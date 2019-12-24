package com.hcl.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Product findProductByProductName(String productName);
}