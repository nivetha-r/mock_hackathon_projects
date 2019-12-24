package com.hcl.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.store.dto.StoreRequestDto;
import com.hcl.store.entity.Store;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.repository.StoreRepository;

@Service
public class StoreServiceImpl  implements StoreService {
	
	@Autowired
	StoreRepository storeRepository;

	@Override
	public Store saveStore(StoreRequestDto storeRequestDto) {
		Store store=new Store();
		store.setStoreName(storeRequestDto.getStoreName());
		store.setStoreLocation(storeRequestDto.getStoreLocation());
		store.setContactNumber(storeRequestDto.getContactNumber());
		storeRepository.save(store);
		return store;
	}

	@Override
	public Store findStoreByStoreId(Integer StoreId) throws StoreNotFoundException {
		Store store=storeRepository.findStoreByStoreId(StoreId);
		if(store==null) {
			throw new StoreNotFoundException("store is not available");
		}
		return store;
	}

}

