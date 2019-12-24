package com.hcl.trading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.entity.Stock;
import com.hcl.trading.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;

	public List<Stock> findAllStocks(){
		return (List<Stock>)stockRepository.findAll();
		}

	}
