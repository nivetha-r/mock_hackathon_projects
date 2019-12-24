package com.hcl.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.training.entity.CourseList;
import com.hcl.training.entity.UserDetails;

public interface CourseListRepository extends JpaRepository<CourseList, String> {

	public List<CourseList> findBycourseId(int courseId);

	//public List<CourseList> findByUserDetails(UserDetails userDetails);

}
