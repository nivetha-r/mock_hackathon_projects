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
import org.springframework.http.HttpStatus;

import com.hcl.store.dto.MyOrderDto;
import com.hcl.store.entity.MyOrder;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.exception.UserOrderListException;
import com.hcl.store.service.OrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class OrderControllerTests {

	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	MyOrderDto myOrderDto = new MyOrderDto();

	@Test
	public void testProductOrderPositive() throws StoreNotFoundException, UserNotFoundException {
		myOrderDto.setProductName("watches");
		myOrderDto.setStoreName("jk stores");
		myOrderDto.setUserId(1);
		String message = "Product succesfully ordered";
		Mockito.when(orderService.myOrder(myOrderDto)).thenReturn(message);
		int result = orderController.productOrder(myOrderDto).getStatusCodeValue();
		assertEquals(200, result);
	}

	@Test
	public void testProductOrderNegative() throws StoreNotFoundException, UserNotFoundException {
		myOrderDto.setProductName("laptops");
		myOrderDto.setStoreName("mk stores");
		myOrderDto.setUserId(2);
		String message = "Product not ordered";
		Mockito.when(orderService.myOrder(myOrderDto)).thenReturn(message);
		HttpStatus actual = orderController.productOrder(myOrderDto).getStatusCode();
		assertEquals(HttpStatus.NO_CONTENT, actual);
	}

	@Test
	public void testGetMyOrderPositive() throws UserNotFoundException, UserOrderListException {
		MyOrder myOrder = new MyOrder();
		List<MyOrder> productList = new ArrayList<MyOrder>();
		myOrder.setOrderId(1);
		myOrder.setPrice(500);
		myOrder.setProductName("watches");
		myOrder.setStoreId(52);
		myOrder.setStoreName("jk stores");
		myOrder.setUserId(1);
		myOrder.setUserName("Nivi");
		productList.add(myOrder);
		Integer userId = 1;
		Mockito.when(orderService.listMyOrder(userId)).thenReturn(productList);
		// Mockito.when(OrderService.listMyOrder(userId)).thenReturn(productList);
		int result = orderController.getMyOrder(1).getStatusCodeValue();
		assertEquals(200, result);
	}

	@Test
	public void testGetMyOrderNegative() throws UserNotFoundException, UserOrderListException {
		List<MyOrder> productList = new ArrayList<MyOrder>();
		Mockito.when(orderService.listMyOrder(1)).thenReturn(productList);
		int result = orderController.getMyOrder(1).getStatusCodeValue();
		assertEquals(406, result);
	}

}
