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

import com.hcl.store.entity.Product;
import com.hcl.store.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTests {
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductService productService;
	
	
	
	@Test
	public void testsaveProductPositive() {
	Product product=new Product();
	product.setProductName("watches");
	String productName = "watches";
	Mockito.when(productService.saveProduct(productName)).thenReturn(product);
	int result=productController.saveProduct(productName).getStatusCodeValue();
	assertEquals(200, result);
	
	
	}
	
	@Test
	public void testsaveProductNegative() {
	Product product=new Product();
	String productName = "watches";
	product.setProductName("laptops");
	Mockito.when(productService.saveProduct("laptops")).thenReturn(product);
	int actual=productController.saveProduct(productName).getStatusCodeValue();
	assertEquals(404, actual);
	
	
	}
	
	@Test
	public void testgetProductNamePositive()  {
		List<Product> productList= new ArrayList<Product>();
		Product product=new Product();
		String productName="watches";
		product.setProductName("watches");
		productList.add(product);
		Mockito.when(productService.findProductByProductName(productName)).thenReturn(productList);
		int actual=productController.getProductName(productName).getStatusCodeValue();
		assertEquals(200,actual);
	}	

	@Test
	public void testgetProductNameNegative()  {
		List<Product> productList= new ArrayList<Product>();
		Product product=new Product();
		String productName="watches";
		product.setProductName("laptops");
		productList.add(product);
		Mockito.when(productService.findProductByProductName("laptops")).thenReturn(productList);
		int actual=productController.getProductName(productName).getStatusCodeValue();
		assertEquals(404,actual);
		

}
}
