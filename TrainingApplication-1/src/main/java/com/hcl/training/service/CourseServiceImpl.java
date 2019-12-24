package com.hcl.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.entity.Courses;
import com.hcl.training.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
     @Autowired
     CourseRepository CourseRepository;
     
	

	@Override
	public List<Courses> findAll() {
		return CourseRepository.findAll();
	
	}

}
