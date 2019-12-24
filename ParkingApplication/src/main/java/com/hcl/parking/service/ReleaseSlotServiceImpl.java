package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.constants.ParkingConstants;
import com.hcl.parking.dto.ReleaseRequestDto;
import com.hcl.parking.dto.ReleaseResponseDto;
import com.hcl.parking.entity.AvailableSlot;
import com.hcl.parking.entity.Registration;
import com.hcl.parking.entity.Slot;
import com.hcl.parking.exceptions.CommonException;
import com.hcl.parking.exceptions.UserNotFoundException;
import com.hcl.parking.repository.AvailableSlotsRepository;
import com.hcl.parking.repository.RegistrationRepository;
import com.hcl.parking.repository.SlotRepository;

@Service
public class ReleaseSlotServiceImpl implements ReleaseSlotService{

	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	SlotRepository slotRepository;
	@Autowired
	AvailableSlotsRepository availableSlotsRepository;

	

	@Override
	public ReleaseResponseDto releaseSlots(ReleaseRequestDto releaseRequestDto) {
		Optional<Registration> registration = registrationRepository.findByRegistrationId(releaseRequestDto.getRegistrationId());
		if (!registration.isPresent())
			throw new UserNotFoundException("User not found"+ releaseRequestDto.getRegistrationId());
		Optional<Slot> slot = slotRepository.findByRegistrationId(releaseRequestDto.getRegistrationId());
		if (!slot.isPresent())
			throw new CommonException(ParkingConstants.SLOTS_NOT_FOUND + releaseRequestDto.getRegistrationId());
		LocalDate fromDate = releaseRequestDto.getFromDate();
		LocalDate toDate = releaseRequestDto.getToDate();
		if (fromDate.compareTo(LocalDate.now()) != 0 && fromDate.compareTo(LocalDate.now()) < 0)
			throw new CommonException(ParkingConstants.ERROR_FROM_DATE);
		if (fromDate.compareTo(toDate) != 0 && fromDate.compareTo(toDate) > 0)
			throw new CommonException(ParkingConstants.ERROR_TO_DATE);
		List<LocalDate> dates = new ArrayList<>();
		LocalDate currentDate = fromDate;
		ReleaseResponseDto releaseResponseDto = new ReleaseResponseDto();
		while (currentDate.isBefore(toDate) || currentDate.equals(toDate)) {
			dates.add(currentDate);
			AvailableSlot availableSlot = new AvailableSlot();
			availableSlot.setSlotId(slot.get().getSlotId());
			availableSlot.setStatus("Available");
			availableSlot.setOwnerId(releaseRequestDto.getRegistrationId());
			availableSlot.setAvailableDate(currentDate);
			AvailableSlot response = availableSlotsRepository.save(availableSlot);
			currentDate = currentDate.plusDays(1);
			releaseResponseDto.setMessage("Slot released Successfully");
		}
		return releaseResponseDto;
	}

}
