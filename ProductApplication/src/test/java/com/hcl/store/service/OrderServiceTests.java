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

import com.hcl.store.dto.MyOrderDto;
import com.hcl.store.entity.MyOrder;
import com.hcl.store.entity.Product;
import com.hcl.store.entity.ProductStore;
import com.hcl.store.entity.Store;
import com.hcl.store.entity.User;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.exception.UserOrderListException;
import com.hcl.store.repository.MyOrderRepository;
import com.hcl.store.repository.ProductRepository;
import com.hcl.store.repository.ProductStoreRepository;
import com.hcl.store.repository.StoreRepository;
import com.hcl.store.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderServiceTests {
	
	@InjectMocks
	OrderServiceImpl orderServiceImpl;

	@Mock
	MyOrderRepository myOrderRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	StoreRepository storeRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	ProductStoreRepository productStoreRepository;
	
	
	@Test
	public void testMyOrder() throws StoreNotFoundException, UserNotFoundException {
	     MyOrderDto myOrderDto=new MyOrderDto();
	     myOrderDto.setProductName("watches");
	     myOrderDto.setStoreName("jk stores");
	     myOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(500.00);
	    MyOrder myOrder=new MyOrder();
		
	    myOrder.setOrderId(1);
	    myOrder.setPrice(500);
	    myOrder.setProductName("watches");
	    myOrder.setStoreId(1);
	    myOrder.setUserId(1);
	    myOrder.setStoreName("jk stores");
	    myOrder.setUserName("Nivi");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("jk stores")).thenReturn(store);
		Mockito.when(productRepository.findProductByProductName("watches")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(myOrderRepository.save(myOrder)).thenReturn(myOrder);
		String result = orderServiceImpl.myOrder(myOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	
	@Test(expected = StoreNotFoundException.class)
	public void testMyOrderNegative() throws StoreNotFoundException, UserNotFoundException {
		MyOrderDto myOrderDto=new MyOrderDto();
		myOrderDto.setProductName("watches");
		myOrderDto.setStoreName("jk stores");
		myOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(500.00);
		MyOrder myOrder=new MyOrder();
		
		myOrder.setOrderId(1);
		myOrder.setPrice(500);
		myOrder.setProductName("watches");
		myOrder.setStoreId(1);
		myOrder.setUserId(1);
		myOrder.setStoreName("jk stores");
		myOrder.setUserName("Janani");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(user);
		Mockito.when(storeRepository.findByStoreName("jk stores")).thenReturn(null);
		Mockito.when(productRepository.findProductByProductName("watches")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(myOrderRepository.save(myOrder)).thenReturn(myOrder);
		String result = orderServiceImpl.myOrder(myOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testMyOrderNegatives() throws StoreNotFoundException, UserNotFoundException {
		MyOrderDto myOrderDto=new MyOrderDto();
		myOrderDto.setProductName("watches");
		myOrderDto.setStoreName("jk stores");
		myOrderDto.setUserId(1);
		
		User user=new User();
		Store store=new Store();
		Product product=new Product();
		product.setProductId(1);
		
		ProductStore productStore=new ProductStore();
		productStore.setPrice(500.00);
		MyOrderDto myOrder=new MyOrderDto();
	
		
		
		myOrder.setUserId(1);
		myOrder.setPrice(500);
		myOrder.setProductName("watches");
		myOrder.setUserId(1);
		myOrder.setStoreName("jk stores");
		
		Mockito.when(userRepository.findUserByUserId(1)).thenReturn(null);
		Mockito.when(storeRepository.findByStoreName("jk stores")).thenReturn(store);
		Mockito.when(productRepository.findProductByProductName("watches")).thenReturn(product);
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStore);
		Mockito.when(myOrderRepository.save(myOrder)).thenReturn(myOrder);
		String result =orderServiceImpl.myOrder(myOrderDto);		
		assertEquals("Product succesfully ordered", result);
		
	}
	
	
	@Test
	public void testListMyOrder() throws UserNotFoundException, UserOrderListException {
		MyOrder myOrder=new MyOrder();
		List<MyOrder> listmyOrder=new ArrayList<MyOrder>();
		myOrder.setUserId(1);
		myOrder.setPrice(100);
		myOrder.setProductName("watches");
		myOrder.setStoreName("jk stores");
		myOrder.setUserId(1);
		listmyOrder.add(myOrder);
		
		Mockito.when(myOrderRepository.findByUserId(1)).thenReturn(listmyOrder);
		listmyOrder =orderServiceImpl.listMyOrder(1);
		
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testListMyOrderNegative() throws UserNotFoundException, UserOrderListException {
		MyOrder myOrder=new MyOrder();
		List<MyOrder> listmyOrder=new ArrayList<MyOrder>();
		myOrder.setOrderId(1);
		myOrder.setPrice(100);
		myOrder.setProductName("watches");
		myOrder.setStoreId(1);
		myOrder.setStoreName("jk stores");
		myOrder.setUserId(1);
		myOrder.setUserName("Nivi");
		listmyOrder.add(myOrder);
		
		Mockito.when(myOrderRepository.findByUserId(1)).thenReturn(listmyOrder);
		listmyOrder =orderServiceImpl.listMyOrder(null);
		
	}


//	@Test(expected = UserOrderListException.class)
//	public void testListMyOrderforNegatives() throws UserNotFoundException, UserOrderListException {
//		MyOrder myOrder=new MyOrder();
//		List<MyOrder> listmyOrder=new ArrayList<MyOrder>();
//		myOrder.setOrderId(1);
//		myOrder.setPrice(100);
//		myOrder.setProductName("watches");
//		myOrder.setStoreId(1);
//		myOrder.setStoreName("jk stores");
//		myOrder.setUserId(1);
//		myOrder.setUserName("Nivi");
//		listmyOrder.add(myOrder);
//		
//		Mockito.when(myOrderRepository.findByUserId(1)).thenReturn(listmyOrder);
//		listmyOrder =orderServiceImpl.listMyOrder(null);
//		
//	}

}
