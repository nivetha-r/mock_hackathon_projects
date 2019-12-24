package com.hcl.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.store.dto.ProductStoreResponseDto;
import com.hcl.store.service.ProductStoreService;

/**
 * 
 * @author Nivetha
 *
 */
@RestController
@RequestMapping("/productstores")
public class ProductStoreController {
	
	@Autowired
	ProductStoreService productStoreService;
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	@GetMapping("/productstore/product")
	public ResponseEntity<List<ProductStoreResponseDto>> productDetails(@RequestParam String productName ) {
		List<ProductStoreResponseDto> productDetail=productStoreService.productDetails(productName);
		return new ResponseEntity<>(productDetail,HttpStatus.OK);
	}
}