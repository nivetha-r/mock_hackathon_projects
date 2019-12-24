package com.hcl.store.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.dto.StoreRequestDto;
import com.hcl.store.entity.Store;
import com.hcl.store.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTests {
	
	@InjectMocks
	StoreController storeController;
	
	@Mock
	StoreService storeService;
	
	@Test
	public void testsaveStorePositive() {
	Store store=new Store();
	StoreRequestDto  storeRequestDto=new StoreRequestDto();
	storeRequestDto.setStoreName("jk stores");
	storeRequestDto.setStoreLocation("katpadi");
	
	Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(store);
	int result=storeController.saveStore(storeRequestDto).getStatusCodeValue();
	assertEquals(200, result);
	
	
	}
	
	@Test
	public void testsaveStoreNegative() {
	Store store=new Store();
	StoreRequestDto  storeRequestDto=new StoreRequestDto();
	StoreRequestDto  storeRequestDto2=new StoreRequestDto();
	storeRequestDto.setStoreName("bhvgh");
	storeRequestDto.setStoreLocation("jdjhd");

	Mockito.when(storeService.saveStore(storeRequestDto)).thenReturn(store);
	int result=storeController.saveStore(storeRequestDto2).getStatusCodeValue();
	assertEquals(200, result);
	
	
	}

}
