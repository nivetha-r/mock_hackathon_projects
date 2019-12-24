package com.ticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.entity.Place;
import com.ticketbooking.repository.PlaceRepository;

@Service
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	PlaceRepository placeRepository;

	@Override
	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	@Override
	public Place findPlaceByPlaceId(Integer placeId) {
		Place place=placeRepository.findPlaceByPlaceId(placeId);
		return place;

	}
}

