package com.hcl.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.dto.RequestSlotDto;
import com.hcl.parking.dto.RequestSlotResponseDto;
import com.hcl.parking.entity.RequestSlot;
import com.hcl.parking.exceptions.UserNotFoundException;
import com.hcl.parking.repository.RequestSlotRepository;

@Service
public class RequestSlotServiceImpl implements RequestSlotService {

	@Autowired
	RequestSlotRepository requestSlotRepository;

	@Override
	public RequestSlotResponseDto requestSlot(RequestSlotDto requestSlotDto) {
		RequestSlot requestSlot = new RequestSlot();
		RequestSlotResponseDto response = new RequestSlotResponseDto();
		if (requestSlotDto.getRegistrationId() == null)
			throw new UserNotFoundException("User not found");
		else {
			requestSlot.setRegistrationId(requestSlotDto.getRegistrationId());
			requestSlot.setRequestDate(requestSlotDto.getDate());
			requestSlotRepository.save(requestSlot);
			response.setMessage("Request sent successfully");
		}
		return response;

	}


}
