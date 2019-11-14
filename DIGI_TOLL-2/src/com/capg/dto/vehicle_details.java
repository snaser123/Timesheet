 package com.capg.dto;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="VEHICLE_Reg_details")
public class vehicle_details {
@Id
private int id;
	
	
	private Date date_of_register;
	private String owner_name;
	private String model;
	private String vehicle_no;
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	private String type;
	private String lic_no;
	private String Status;
	private String colour;
	private byte[] photo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_of_register() {
		return date_of_register;
	}
	public void setDate_of_register(Date date_of_register) {
		this.date_of_register = date_of_register;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLic_no() {
		return lic_no;
	}
	public void setLic_no(String lic_no) {
		this.lic_no = lic_no;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "vehicle_details [getVehicle_no()=" + getVehicle_no() + ", getId()=" + getId()
				+ ", getDate_of_register()=" + getDate_of_register() + ", getOwner_name()=" + getOwner_name()
				+ ", getModel()=" + getModel() + ", getType()=" + getType() + ", getLic_no()=" + getLic_no()
				+ ", getStatus()=" + getStatus() + ", getColour()=" + getColour() + ", getPhoto()="
				+ Arrays.toString(getPhoto()) + "]";
	}
	
	
	
}
