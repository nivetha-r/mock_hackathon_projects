package com.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.entity.Place;
import com.ticketbooking.service.PlaceService;



@RestController
@RequestMapping("/places")
@CrossOrigin
public class PlaceController {
	
	@Autowired
	PlaceService placeService;
	@GetMapping(value = "")
	public ResponseEntity<List<Place>> listAllPlaces(Integer placeId) {
		List<Place> place = placeService.findAll();
		//log.info("List the All places");
		if (Place.isEmpty()) {
			return new ResponseEntity<>(place, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(place, HttpStatus.OK);
	}

}
	
	