package com.hcl.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parking.dto.ReleaseRequestDto;
import com.hcl.parking.dto.ReleaseResponseDto;
import com.hcl.parking.service.ReleaseSlotService;

@RestController
@RequestMapping("")
public class ReleaseSlotController {
	@Autowired
	ReleaseSlotService releaseSlotService;

	@PostMapping("/release")
	public ResponseEntity<ReleaseResponseDto> releaseSlots(@RequestBody ReleaseRequestDto releaseRequestDto) {
		ReleaseResponseDto response = releaseSlotService.releaseSlots(releaseRequestDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
