package com.hcl.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.dto.MyOrderDto;
import com.hcl.store.entity.MyOrder;

@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {

	public List<MyOrder> findByUserId(Integer userId);

	public Object save(MyOrderDto myOrder);

}
