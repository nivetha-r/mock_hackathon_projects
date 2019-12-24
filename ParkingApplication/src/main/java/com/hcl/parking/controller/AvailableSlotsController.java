package com.hcl.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.SlotsResponseDto;
import com.hcl.parking.service.AvailableSlotsService;

@RestController
@RequestMapping("")
public class AvailableSlotsController {
       @Autowired 
      AvailableSlotsService availableSlotsService;


@GetMapping("/showAvailableSlots")
public ResponseEntity<List<SlotsResponseDto>> getAvailableSlots(){
	return new ResponseEntity<>(availableSlotsService.getAllAvailableSlots(), HttpStatus.OK);
}
}
