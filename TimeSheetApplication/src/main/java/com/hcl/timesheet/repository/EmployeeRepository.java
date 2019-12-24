package com.hcl.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hcl.timesheet.entity.Employee;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findAllByEmployeeId(Integer employeeId);

}
