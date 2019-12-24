package com.hcl.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employee")
public class Employee{
	@Id
	private Integer employeeId;
	private String employeeName;
	private String password;

}