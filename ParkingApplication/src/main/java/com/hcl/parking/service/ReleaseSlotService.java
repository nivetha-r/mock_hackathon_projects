package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.ReleaseRequestDto;
import com.hcl.parking.dto.ReleaseResponseDto;

@Service
public interface ReleaseSlotService {

	public ReleaseResponseDto releaseSlots(ReleaseRequestDto releaseRequestDto);

}
