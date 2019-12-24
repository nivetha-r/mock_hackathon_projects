package com.hcl.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.store.dto.MyOrderDto;
import com.hcl.store.entity.MyOrder;
import com.hcl.store.exception.StoreNotFoundException;
import com.hcl.store.exception.UserNotFoundException;
import com.hcl.store.exception.UserOrderListException;

@Service
public interface OrderService {
	
	public  String myOrder(MyOrderDto myOrderDto) throws StoreNotFoundException, UserNotFoundException; 
	
	public List<MyOrder> listMyOrder(Integer userId) throws UserNotFoundException, UserOrderListException;


}
