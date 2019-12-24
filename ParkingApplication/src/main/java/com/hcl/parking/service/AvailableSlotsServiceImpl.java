package com.hcl.parking.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parking.constants.ParkingConstants;
import com.hcl.parking.dto.SlotsResponseDto;
import com.hcl.parking.entity.AvailableSlot;
import com.hcl.parking.exceptions.CommonException;
import com.hcl.parking.repository.AvailableSlotsRepository;

@Service
public class AvailableSlotsServiceImpl implements AvailableSlotsService {
	@Autowired
	AvailableSlotsRepository availableSlotsRepository;

	@Override
	public List<SlotsResponseDto> getAllAvailableSlots() {
		List<SlotsResponseDto> listslot = new ArrayList<>();
		LocalDate availableDate = LocalDate.now();
		List<AvailableSlot> listAvailable = availableSlotsRepository.findAll();
		if (listAvailable.isEmpty())
			throw new CommonException(ParkingConstants.SLOTS_NOT_AVAILABLE);
		listAvailable.stream().forEach(l -> {
			if (l.getAvailableDate().equals(availableDate)) {
				SlotsResponseDto slotsResponseDto = new SlotsResponseDto();
				BeanUtils.copyProperties(l, slotsResponseDto);
				listslot.add(slotsResponseDto);
			}
		});

		return listslot;
	}
}
