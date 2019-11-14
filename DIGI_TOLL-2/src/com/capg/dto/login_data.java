package com.capg.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class login_data {

	@Override
	public String toString() {
		return "SHO [loginid=" + loginid + ", password=" + password + ", id=" + id + ", role=" + role + "]";
	}
	private String loginid;
	private String password;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String role;
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
