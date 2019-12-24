package com.hcl.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

	
	
	public Store findStoreByStoreId(Integer StoreId);

	public Store findByStoreName(String storeName);


} 