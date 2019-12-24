package com.hcl.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.store.dto.MyOrderDto;
import com.hcl.store.entity.MyOrder;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.exception.UserOrderListException;
import com.hcl.store.service.OrderService;

/**
 * 
 * @author Nivetha
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	/**
	 * 
	 * @param myOrderDto
	 * @return
	 * @throws StoreNotFoundException
	 * @throws UserNotFoundException
	 */
	@PostMapping("")
	public ResponseEntity<String> productOrder(@RequestBody MyOrderDto myOrderDto)
			throws StoreNotFoundException, UserNotFoundException {
		String result = orderService.myOrder(myOrderDto);
		if (result.equals("Product succesfully ordered")) {
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>("Product not ordered", HttpStatus.NO_CONTENT);

	}
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws UserNotFoundException
	 * @throws UserOrderListException
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<List<MyOrder>> getMyOrder(@RequestParam Integer userId)
			throws UserNotFoundException, UserOrderListException {
		
		List<MyOrder> myOrders = orderService.listMyOrder(userId);
		if (myOrders.isEmpty()) {
			return new ResponseEntity<List<MyOrder>>(myOrders, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(myOrders, HttpStatus.OK);

	}

}
