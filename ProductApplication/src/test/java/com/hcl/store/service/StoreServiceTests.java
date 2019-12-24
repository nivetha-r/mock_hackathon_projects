package com.hcl.store.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.dto.StoreRequestDto;
import com.hcl.store.entity.Store;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceTests {

	@InjectMocks
	StoreServiceImpl storeServiceImpl;

	@Mock
	StoreRepository storeRepository;

	@Test
	public void testsaveStorePositive() {
		Store store = new Store();
		StoreRequestDto storeRequestDto = new StoreRequestDto();
		storeRequestDto.setStoreName("jhhj");
		storeRequestDto.setContactNumber("8657465536");
		storeRequestDto.setStoreLocation("hghg");
		store.setStoreName(storeRequestDto.getStoreName());
		store.setStoreLocation(storeRequestDto.getStoreLocation());
		store.setContactNumber(storeRequestDto.getContactNumber());
		Store response = storeServiceImpl.saveStore(storeRequestDto);
		assertEquals(store.getStoreLocation(), response.getStoreLocation());

	}

	@Test
	public void testsaveStoreNegative() {
		Store store = new Store();
		store.setStoreId(2);
		store.setContactNumber("578458");
		store.setStoreLocation("kjk");
		store.setStoreName("mk stores");
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		assertEquals(store, store);

	}

	@Test(expected = StoreNotFoundException.class)
	public void testfindStoreByStoreIdPositive() throws StoreNotFoundException {
		Store store = new Store();

		store.setStoreId(1);
		store.setContactNumber("9876543210");
		store.setStoreLocation("katpadi");
		store.setStoreName("jk stores");

		Mockito.when(storeRepository.findStoreByStoreId(2)).thenReturn(null);
		store = storeServiceImpl.findStoreByStoreId(2);
	}

	@Test(expected = StoreNotFoundException.class)
	public void testfindStoreByStoreIdNegative() throws StoreNotFoundException {

		Store store = new Store();
		store.setContactNumber("9865526711");
		store.setStoreId(1);
		store.setStoreLocation("jhtt");
		store.setStoreName("gfyg");
		Mockito.when(storeRepository.findStoreByStoreId(1)).thenReturn(null);
		store = storeServiceImpl.findStoreByStoreId(1);
	}

}