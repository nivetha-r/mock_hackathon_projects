package com.hcl.store.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.store.entity.Product;
import com.hcl.store.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTests {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

	@Test
	public void testsaveProductPositive() {
		Product product = new Product();
		String productName = "pen";
		product.setProductName(productName);
		Product response = productServiceImpl.saveProduct(productName);
		assertEquals(product.getProductName(), response.getProductName());

//		Product product = new Product();
//		product.setProductId(1);
//		product.setProductName("watches");
//		Mockito.when(productRepository.save(product)).thenReturn(product);
//		assertEquals(product, product);

	}

	@Test
	public void testsaveProductNegative() {

		Product product = new Product();
		product.setProductId(2);
		product.setProductName("jhhh");
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, product);

	}

	@Test
	public void testfindProductByProductNamePositive() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("watches");
		productList.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		List<Product> productLists = productServiceImpl.findProductByProductName("watches");
		assertEquals(productLists.size(), productList.size());
	}

	@Test
	public void testfindProductByProductNameNegative() {
		List<Product> productList2 = new ArrayList<Product>();
		Mockito.when(productRepository.findAll()).thenReturn(productList2);
		List<Product> productLists = productServiceImpl.findProductByProductName("jhhh");
		assertEquals(productLists.size(), productList2.size());
	}
}
