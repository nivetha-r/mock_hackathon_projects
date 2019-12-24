package com.hcl.store.service;

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
import com.hcl.store.repository.ProductStoreRepository;
import com.hcl.store.repository.ReviewRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreServiceTests {

	@InjectMocks
	ProductStoreServiceImpl productStoreServiceImpl;

	@Mock
	ProductStoreRepository productStoreRepository;

	@Mock
	ReviewRepository reviewRepository;

	@Test
	public void testProductDetailsPositive() {

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
		ProductStoreResponsesDto.setPrice(100);
		ProductStoreResponsesDto.setProductName("watches");
		ProductStoreResponsesDto.setRating(2);

		Mockito.when(productStoreRepository.findByProductName("watches")).thenReturn(listProductStore);
		Mockito.when(reviewRepository.findByStoreId(1)).thenReturn(1);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		List<ProductStoreResponseDto> productStoreResponseDtoResult = productStoreServiceImpl.productDetails("watches");
		assertEquals(1, listProductStoreResponseDto.size());

	}
	
	@Test
	public void testProductDetailsNegative() {

		ProductStore productStore = new ProductStore();
		List<ProductStore> listProductStore = new ArrayList<ProductStore>();
		productStore.setId(1);
		productStore.setPrice(100);
		productStore.setProductId(1);
		productStore.setProductName("watches");
		productStore.setStoreId(1);
		listProductStore.add(productStore);

		ProductStoreResponseDto ProductStoreResponsesDto = new ProductStoreResponseDto();
		List<ProductStoreResponseDto> listProductStoreResponseDto = new ArrayList<>();
		ProductStoreResponsesDto.setPrice(100);
		ProductStoreResponsesDto.setProductName("watches");
		ProductStoreResponsesDto.setRating(2);

		Mockito.when(productStoreRepository.findByProductName("pen")).thenReturn(listProductStore);
		Mockito.when(reviewRepository.findByStoreId(1)).thenReturn(1);
		ProductStoreResponsesDto.setStoreId(1);
		listProductStoreResponseDto.add(ProductStoreResponsesDto);

		List<ProductStoreResponseDto> productStoreResponseDtoResult = productStoreServiceImpl.productDetails("laptops");
		assertEquals(1, listProductStoreResponseDto.size());

	}

}
