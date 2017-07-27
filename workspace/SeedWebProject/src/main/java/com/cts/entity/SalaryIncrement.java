package com.cts.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

@Entity
public class SalaryIncrement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Transient
	int employeeId;
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	@Min(value=1000)
	@Column
	double amount;
	@Column
	Date incrementDate;
	
	@Override
	public String toString() {
		return "SalaryIncrement [id=" + id + ", amount=" + amount + ", incrementDate=" + incrementDate + "]";
	}

	public SalaryIncrement(){
		
	}
	
	public SalaryIncrement(double amount, Date incrementDate) {
		super();
		this.amount = amount;
		this.incrementDate = incrementDate;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getIncrementDate() {
		return incrementDate;
	}


	public void setIncrementDate(Date incrementDate) {
		this.incrementDate = incrementDate;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@ManyToOne
	@JoinColumn(nullable=false)
	Employee employee;
	
	

}
