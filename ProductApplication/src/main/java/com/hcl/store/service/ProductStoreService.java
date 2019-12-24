package com.hcl.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.store.dto.ProductStoreResponseDto;

@Service
public interface ProductStoreService {

	public List<ProductStoreResponseDto> productDetails(String productName);
}