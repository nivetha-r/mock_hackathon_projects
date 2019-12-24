package com.hcl.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.store.entity.Product;
import com.hcl.store.service.ProductService;

/**
 * 
 * @author Nivetha
 *
 */

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	@PostMapping("/{productName}")
	public ResponseEntity<Product> saveProduct(@RequestParam (name="productName")String productName) {
		Product product=productService.saveProduct(productName);
		if(product==null) {
			return new ResponseEntity<> (product,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<> (product,HttpStatus.OK);
		
	}
	/**
	 * 
	 * @param productName
	 * @return
	 */
	
	@GetMapping("/{productName}") 
	public ResponseEntity<List<Product>> getProductName(@RequestParam String productName ) {
		List<Product> product=productService.findProductByProductName(productName);
		if(product.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(product,HttpStatus.OK);
		
	}
	

	
}