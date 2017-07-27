package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.IncrementDAO;
import com.cts.entity.Employee;
import com.cts.entity.SalaryIncrement;

@Service
public class IncrementService {
	
	@Autowired
	IncrementDAO dao;

	public boolean addEmployee(Employee emp) {
		return dao.addEmployee(emp);
	}

	public Employee findEmployeeById(int id) {
		return dao.findEmployeeById(id);
	}

	public Employee incrementSalary(int id, SalaryIncrement anotherIncrement) {
		return dao.incrementSalary(id,anotherIncrement);
	}

	public List<Employee> findAllEmployees() {
		return dao.findEmployees();
	}

}
