package com.cog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cog.entity.Employee;
import com.cog.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public boolean addEmployee(Employee emp){
		return employeeRepo.addEmployee(emp);
	}

	public Employee updateSalary(int id, double newSalary) {
		if(newSalary<0){
			throw new RuntimeException("Don't make fun of employees");
		}
		return employeeRepo.updateSalary(id, newSalary);
	}

	public List<Employee> findEmployeesBelowMinimumSalary() {
		return employeeRepo.findEmployeesBelowMinimumSalary();
	}

}
