package com.matrimony.cassini.service;

import com.matrimony.cassini.dto.InterestRequestDto;
import com.matrimony.cassini.dto.InterestResponseDto;
import com.matrimony.cassini.exception.UserNotFoundException;

public interface UserMappingService {

	InterestResponseDto showInterest(InterestRequestDto interestRequestDto) throws UserNotFoundException;

}
