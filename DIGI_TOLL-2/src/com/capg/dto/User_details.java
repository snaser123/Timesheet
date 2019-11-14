package com.capg.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User_details {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int wallet_amount;
	private Date date_of_register;
	private String vehicle_no;
	private String mailId;
	private String mobile;
	@Column(unique=true, nullable=false) 
	private String loginid;
	private String role;
	private String password;
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
	public int getWallet_amount() {
		return wallet_amount;
	}
	public void setWallet_amount(int wallet_amount) {
		this.wallet_amount = wallet_amount;
	}
	public Date getDate_of_register() {
		return date_of_register;
	}
	public void setDate_of_register(Date date_of_register) {
		this.date_of_register = date_of_register;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User_details [id=" + id + ", wallet_amount=" + wallet_amount + ", date_of_register=" + date_of_register
				+ ", vehicle_no=" + vehicle_no + ", mailId=" + mailId + ", mobile=" + mobile + ", loginid=" + loginid
				+ ", role=" + role + ", getId()=" + getId() + ", getWallet_amount()=" + getWallet_amount()
				+ ", getDate_of_register()=" + getDate_of_register() + ", getVehicle_no()=" + getVehicle_no()
				+ ", getMailId()=" + getMailId() + ", getMobile()=" + getMobile() + ", getLoginid()=" + getLoginid()
				+ ", getRole()=" + getRole() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
