package com.ticketbooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ticketbooking.dto.PlaceResponseDto;
import com.ticketbooking.entity.Place;

@Service
public interface PlaceService {

	List<Place> findAll();

	Place findPlaceByPlaceId(Integer placeId);

}
