package com.hcl.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.SlotsResponseDto;

@Service
public interface AvailableSlotsService {

	public List<SlotsResponseDto> getAllAvailableSlots();

}
