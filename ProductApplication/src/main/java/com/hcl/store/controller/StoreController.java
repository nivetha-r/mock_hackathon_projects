package com.hcl.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.store.dto.StoreRequestDto;
import com.hcl.store.entity.Store;
import com.hcl.store.service.StoreService;
/**
 * 
 * @author Nivetha
 *
 */
@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreService  storeService;
	
	/**
	 * 
	 * @param storeRequestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<Store> saveStore(@RequestBody StoreRequestDto storeRequestDto) {
		Store store=storeService.saveStore(storeRequestDto);
		return new ResponseEntity<>(store,HttpStatus.OK);
		
	}

}