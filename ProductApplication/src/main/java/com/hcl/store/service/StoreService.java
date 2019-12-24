package com.hcl.store.service;

import org.springframework.stereotype.Service;

import com.hcl.store.dto.StoreRequestDto;
import com.hcl.store.entity.Store;
import com.hcl.store.exception.StoreNotFoundException;

@Service
public interface StoreService {
	
	Store saveStore(StoreRequestDto storeRequestDto);
	
	Store findStoreByStoreId(Integer StoreId) throws StoreNotFoundException;

}