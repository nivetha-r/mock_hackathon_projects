package com.hcl.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	@Id
	private Long userId;
	private String userName;
	private String password;
	private String userMobileNumber;
	

}
