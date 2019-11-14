package com.capg.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity

@Table(uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class Pass_details {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date start_date;
	private Date End_date;
	private String pass_type;
	private String vehicle_no;
	private String TollGateID;
	@Column(unique=true, nullable=false) 
	private String username;
	private int wallet;
	private int routecost;
	public int getRoutecost() {
		return routecost;
	}
	public void setRoutecost(int routecost) {
		this.routecost = routecost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
	public int getWallet() {
		return wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTollGateID() {
		return TollGateID;
	}
	public void setTollGateID(String tollGateID) {
		TollGateID = tollGateID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return End_date;
	}
	public void setEnd_date(Date end_date) {
		End_date = end_date;
	}
	public String getPass_type() {
		return pass_type;
	}
	public void setPass_type(String pass_type) {
		this.pass_type = pass_type;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	@Override
	public String toString() {
		return "Pass_details [id=" + id + ", start_date=" + start_date + ", End_date=" + End_date + ", pass_type="
				+ pass_type + ", vehicle_no=" + vehicle_no + ", TollGateID=" + TollGateID + ", username=" + username
				+ ", wallet=" + wallet + ", routecost=" + routecost + ", status=" + status + ", getRoutecost()="
				+ getRoutecost() + ", getStatus()=" + getStatus() + ", getWallet()=" + getWallet() + ", getUsername()="
				+ getUsername() + ", getTollGateID()=" + getTollGateID() + ", getId()=" + getId() + ", getStart_date()="
				+ getStart_date() + ", getEnd_date()=" + getEnd_date() + ", getPass_type()=" + getPass_type()
				+ ", getVehicle_no()=" + getVehicle_no() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
