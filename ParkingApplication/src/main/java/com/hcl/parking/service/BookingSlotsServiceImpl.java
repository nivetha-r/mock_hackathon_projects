package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.constants.ParkingConstants;
import com.hcl.parking.dto.BookingRequestDto;
import com.hcl.parking.dto.BookingResponseDto;
import com.hcl.parking.entity.AvailableSlot;
import com.hcl.parking.entity.RequestSlot;
import com.hcl.parking.exceptions.CommonException;
import com.hcl.parking.repository.AvailableSlotsRepository;
import com.hcl.parking.repository.RegistrationRepository;
import com.hcl.parking.repository.RequestSlotRepository;

@Service
public class BookingSlotsServiceImpl implements BookingSlotsService {
	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RequestSlotRepository requestSlotRepository;

	@Autowired
	AvailableSlotsRepository availableSlotsRepository;

	Random random = new Random();

	@Override
	public BookingResponseDto bookingSlot(BookingRequestDto bookingRequestDto) {
		Optional<AvailableSlot> availableSlot = availableSlotsRepository
				.findById(bookingRequestDto.getAvailableslotId());
		if (!availableSlot.isPresent())
			throw new CommonException(ParkingConstants.SLOTS_NOT_AVAILABLE);

		List<AvailableSlot> availableSlots = availableSlotsRepository.findByAvailableDate(LocalDate.now());
		if (availableSlots.isEmpty())
			throw new CommonException(ParkingConstants.SLOTS_NOT_AVAILABLE);
		try {
			availableSlotsRepository.lockingSlot(availableSlots.get(0).getAvailableslotId());
		} catch (org.hibernate.exception.LockAcquisitionException e) {
			throw new CommonException("slots already booked");

		}


		AvailableSlot availableSlot1 = availableSlots.get(0);
		if (availableSlot1.getStatus().equalsIgnoreCase("Booked"))
			throw new CommonException("Already booked");

	 availableSlot1.setBookedempId(bookingRequestDto.getRegistrationId());
		availableSlot1.setStatus("booked");
		try {
			availableSlotsRepository.save(availableSlot1);
		} catch (Exception e) {
			throw new CommonException(" Slot Already booked");
		}
	

		
		return new BookingResponseDto();
		}

	@Override
	public BookingResponseDto doRaffle() {
		List<RequestSlot> requestSlotList = requestSlotRepository.findByRequestDate(LocalDate.now().plusDays(1));
		List<AvailableSlot> availableSlotsList = availableSlotsRepository
				.findByAvailableDate(LocalDate.now().plusDays(1));
		for (int i = 0; i < availableSlotsList.size(); i++) {
			for (int j = 0; j < requestSlotList.size(); j++) {
				int randomIndex = random.nextInt(requestSlotList.size() - 1);

				int registrationId = requestSlotList.get(randomIndex).getRegistrationId();

				availableSlotsList.get(randomIndex).setBookedempId(registrationId);
				availableSlotsList.get(randomIndex).setStatus("booked");

				availableSlotsRepository.save(availableSlotsList.get(randomIndex));

			}
		}

		return new BookingResponseDto();
	}

}

	
