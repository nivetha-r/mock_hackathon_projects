package com.nivi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column
	private int userid;
	@Column
	private String username;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + "]";
	}
	public User(int userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
