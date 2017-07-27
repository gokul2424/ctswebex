package com.cts.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	String name;
	
	@NotNull
	@Min(value=5000)
	@Column
	double salary;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
	List<SalaryIncrement> increments;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	public Employee(){
		
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<SalaryIncrement> getIncrements() {
		return increments;
	}

	public void setIncrements(List<SalaryIncrement> increments) {
		this.increments = increments;
	}
	

}
