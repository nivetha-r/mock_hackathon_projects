package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.RequestSlotDto;
import com.hcl.parking.dto.RequestSlotResponseDto;

@Service
public interface RequestSlotService {

	public RequestSlotResponseDto requestSlot(RequestSlotDto requestSlotDto);

}
