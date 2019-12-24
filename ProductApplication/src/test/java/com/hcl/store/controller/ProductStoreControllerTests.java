package com.hcl.store.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.dto.ProductStoreResponseDto;
import com.hcl.store.entity.ProductStore;
import com.hcl.store.service.ProductStoreService;

@RunWith(MockitoJUnitRunner.Silent.class)

public class ProductStoreControllerTests {

	@InjectMocks
	ProductStoreController productStoreController;

	@Mock
	ProductStoreService productStoreService;

	@Test
	public void testproductDetailsPositive() {
		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(500);
		productStore.setProductId(1);
		productStore.setProductName("watches");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto ProductStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		ProductStoreResponsesDto.setPrice(500);
		ProductStoreResponsesDto.setProductName("watches");
		ProductStoreResponsesDto.setRating(2);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		Mockito.when(productStoreService.productDetails("watches")).thenReturn(listProductStoreResponseDto);
		int result = productStoreController.productDetails("watches").getStatusCodeValue();
		assertEquals(200, result);
	}
	
	@Test
	public void testproductDetailsNegative() {
		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(500);
		productStore.setProductId(1);
		productStore.setProductName("watches");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto ProductStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		ProductStoreResponsesDto.setPrice(500);
		ProductStoreResponsesDto.setProductName("watches");
		ProductStoreResponsesDto.setRating(2);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		Mockito.when(productStoreService.productDetails("watches")).thenReturn(listProductStoreResponseDto);
		int result = productStoreController.productDetails("laptops").getStatusCodeValue();
		assertEquals(200, result);
	}

}