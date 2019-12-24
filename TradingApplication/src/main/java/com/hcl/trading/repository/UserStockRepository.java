package com.hcl.trading.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trading.entity.UserStock;

@Repository
public interface UserStockRepository extends CrudRepository<UserStock, Integer> {
	

}