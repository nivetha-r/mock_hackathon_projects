package com.hcl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.entity.Courses;
import com.hcl.training.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
    CourseService courseService;
	
	@GetMapping("/AllCourses")
	 public ResponseEntity<List<Courses>> getAllCourses(){
		 List<Courses> courses=courseService.findAll();
		 if(courses.isEmpty()) {
			 return new ResponseEntity<List<Courses>>(courses,HttpStatus.NOT_FOUND);
		 }else {
			 return new ResponseEntity<List<Courses>>(courses,HttpStatus.OK);

		 }
		
		 
	 }

}
