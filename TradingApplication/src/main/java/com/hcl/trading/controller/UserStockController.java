package com.hcl.trading.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.entity.UserStock;
import com.hcl.trading.service.UserStockService;

@RestController
@RequestMapping("/userstock")
public class UserStockController {
	
	@Autowired
	UserStockService userstockService;
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public ResponseEntity<List<UserStock>> showStockById(@PathVariable("userid") Integer userid) {
       List<UserStock> userStock = userstockService.findByUserid(userid);
        if (userStock.isEmpty()) {
            return new ResponseEntity<List<UserStock>>(userStock, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<UserStock>>(userStock, HttpStatus.OK);
    }
 
 @PostMapping( "/buy")
    public ResponseEntity<String> buy(@RequestBody Buy buy) {
       
        return new ResponseEntity<String>(userStocksService.buy(buy), HttpStatus.OK);
    }

	}
