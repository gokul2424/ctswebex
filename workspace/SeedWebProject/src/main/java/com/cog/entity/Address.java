package com.cog.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Address {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	int houseNumber;
	@Column
	String locality;
	@Column
	String city;
	// mappedBy
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Address(){
		
	}
	public Address(int houseNumber, String locality, String city) {
		super();
		this.houseNumber = houseNumber;
		this.locality = locality;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
