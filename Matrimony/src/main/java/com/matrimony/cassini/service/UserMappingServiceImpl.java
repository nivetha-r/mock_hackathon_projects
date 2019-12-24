package com.matrimony.cassini.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.cassini.constants.Constant;
import com.matrimony.cassini.dto.InterestRequestDto;
import com.matrimony.cassini.dto.InterestResponseDto;
import com.matrimony.cassini.entity.User;
import com.matrimony.cassini.entity.UserMapping;
import com.matrimony.cassini.exception.UserNotFoundException;
import com.matrimony.cassini.repository.UserMappingRepository;
import com.matrimony.cassini.repository.UserRepository;

@Service
public class UserMappingServiceImpl implements UserMappingService {
	@Autowired
	UserMappingRepository userMappingRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public InterestResponseDto showInterest(InterestRequestDto interestRequestDto) throws UserNotFoundException {
		Optional<User> sender = userRepository.findById(interestRequestDto.getFromUserId());
		Optional<User> receiver = userRepository.findById(interestRequestDto.getToUserId());
		if (!sender.isPresent()) {
			throw new UserNotFoundException(Constant.SENDER_PROFILE_NOT_FOUND);
		}
		if (!receiver.isPresent()) {
			throw new UserNotFoundException(Constant.RECEIVER_PROFILE_NOT_FOUND);
		}
		UserMapping mapping = new UserMapping();
		mapping.setStatus("interested");
		mapping.setFromUser(sender.get());
		mapping.setToUser(receiver.get());
		userMappingRepository.save(mapping);
		InterestResponseDto interestResponseDto = new InterestResponseDto();
		interestResponseDto.setMessage(Constant.REQUESTED);
		interestResponseDto.setStatusCode(Constant.OK);
		return interestResponseDto;

	}

}
