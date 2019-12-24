package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.RequestSlotDto;
import com.hcl.parking.dto.RequestSlotResponseDto;
import com.hcl.parking.service.RequestSlotService;

@RestController
@RequestMapping("")
public class RequestSlotController {
	@Autowired
	RequestSlotService requestSlotService;

	@PostMapping("/requestSlot")
	public ResponseEntity<RequestSlotResponseDto> requestSlot(@RequestBody RequestSlotDto requestSlotDto) {
		RequestSlotResponseDto response = requestSlotService.requestSlot(requestSlotDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
