package com.hcl.store.entity;

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
	private Integer userId;
	private String userName;
	private String passWord;

}