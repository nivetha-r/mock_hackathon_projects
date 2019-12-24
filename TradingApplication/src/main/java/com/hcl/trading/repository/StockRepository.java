package com.hcl.trading.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trading.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

}
