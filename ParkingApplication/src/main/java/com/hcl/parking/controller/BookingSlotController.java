package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.BookingRequestDto;
import com.hcl.parking.dto.BookingResponseDto;
import com.hcl.parking.service.BookingSlotsService;

@RestController
@RequestMapping("")
public class BookingSlotController {

	@Autowired
	BookingSlotsService bookingSlotsService;
	
	@PostMapping("/bookingSlot")
	public ResponseEntity<BookingResponseDto> bookingSlots(@RequestBody BookingRequestDto bookingRequestDto) {
		return new ResponseEntity<>(bookingSlotsService.bookingSlot(bookingRequestDto), HttpStatus.CREATED);
	}
	

	@PostMapping("/doRaffle")
	public ResponseEntity<BookingResponseDto> doRaffle() {
	return new ResponseEntity<>(bookingSlotsService.doRaffle(), HttpStatus.CREATED);
	}
}
