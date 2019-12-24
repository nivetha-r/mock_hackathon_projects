package com.hcl.parking.service;

import org.springframework.stereotype.Service;

import com.hcl.parking.dto.BookingRequestDto;
import com.hcl.parking.dto.BookingResponseDto;

@Service
public interface BookingSlotsService {

	BookingResponseDto bookingSlot(BookingRequestDto bookingRequestDto);
	BookingResponseDto doRaffle();

}
