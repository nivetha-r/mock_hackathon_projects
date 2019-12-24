package com.hcl.trading.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	private int userid;
	private int username;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + "]";
	}
	public User(int userid, int username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
