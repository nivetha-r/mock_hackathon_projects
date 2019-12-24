package com.hcl.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	MyOrderRepository myOrderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	ProductStoreRepository productStoreRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public String myOrder(MyOrderDto myOrderDto) throws StoreNotFoundException, UserNotFoundException {
		User user = userRepository.findUserByUserId(myOrderDto.getUserId());
		if (user != null) {
			Store store = storeRepository.findByStoreName(myOrderDto.getStoreName());
			if (store != null) {
				Product product = productRepository.findProductByProductName(myOrderDto.getProductName());
				ProductStore productStore = productStoreRepository.findByProductId(product.getProductId());

				MyOrder myOrder = new MyOrder();
				myOrder.setUserId(myOrderDto.getUserId());
				myOrder.setUserName(user.getUserName());
				myOrder.setStoreId(store.getStoreId());
				myOrder.setStoreName(myOrderDto.getStoreName());
				myOrder.setProductName(myOrderDto.getProductName());
				myOrder.setPrice(productStore.getPrice());
				myOrderRepository.save(myOrder);
			} else {
				throw new StoreNotFoundException("Store is not available");
			}
		} else {
			throw new UserNotFoundException("User is not available");
		}

		return "Product succesfully ordered";
	}

	@Override
	public List<MyOrder> listMyOrder(Integer userId) throws UserNotFoundException, UserOrderListException {
		if (userId != null) {
			List<MyOrder> listOrder = myOrderRepository.findByUserId(userId);
			if (listOrder.isEmpty()) {
				throw new UserOrderListException("myOrder list is empty");
			}
			return listOrder;
		} else {
			throw new UserNotFoundException("User not Available");

		}

	}


}
