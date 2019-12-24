package com.hcl.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.store.dto.ProductStoreResponseDto;
import com.hcl.store.entity.ProductStore;
import com.hcl.store.repository.ProductRepository;
import com.hcl.store.repository.ProductStoreRepository;
import com.hcl.store.repository.ReviewRepository;
import com.hcl.store.repository.StoreRepository;

@Service
public class ProductStoreServiceImpl implements ProductStoreService {
	@Autowired
	ProductStoreRepository productStoreRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	ReviewRepository reviewRepository;
	

	

	@Override
	public List<ProductStoreResponseDto> productDetails(String productName) {
		List<ProductStore> productStores=productStoreRepository.findByProductName(productName);
		List<ProductStoreResponseDto> productStoreResponseDto=new ArrayList<>();
		for (ProductStore productStore : productStores) {
			ProductStoreResponseDto  ProductStoreResponsesDto=new ProductStoreResponseDto();
			ProductStoreResponsesDto.setProductName(productStore.getProductName());
			ProductStoreResponsesDto.setStoreId(productStore.getStoreId());
			ProductStoreResponsesDto.setPrice(productStore.getPrice());
			productStoreResponseDto.add(ProductStoreResponsesDto);
		}
		return productStoreResponseDto;
	}
	}
			
		
