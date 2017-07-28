package com.cts.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Employee;
import com.cts.entity.SalaryIncrement;
import com.cts.service.IncrementService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/beans.xml")
public class SalaryIncrementTest {
	@Autowired
	IncrementService service;
	
	Logger logger = Logger.getLogger(this.getClass());

//	@Test
	public void insertEmployeeWithOneIncrement() {
		Employee emp = new Employee("Arun", 30000);
		
		SalaryIncrement firstIncrement = new SalaryIncrement(30000, new Date());
		firstIncrement.setEmployee(emp);
		
		List<SalaryIncrement> increments = new ArrayList<>();
		increments.add(firstIncrement);
		emp.setIncrements(increments);
		
		boolean result = service.addEmployee(emp);
		assertTrue(result);
		
	}
//	@Test(expected=ConstraintViolationException.class)
	public void insertEmployeeWithOneIncrementNegative() {
		Employee emp = new Employee("Arun", 3000);
		
		SalaryIncrement firstIncrement = new SalaryIncrement(3000, new Date());
		firstIncrement.setEmployee(emp);
		
		List<SalaryIncrement> increments = new ArrayList<>();
		increments.add(firstIncrement);
		emp.setIncrements(increments);
		
		boolean result = service.addEmployee(emp);
		assertTrue(result);
		
	}

	@Test
	public void findEmployeeWithId(){
		int id = 1;		
		logger.info("*************");
		logger.error("++++++++++++");
		Employee emp = service.findEmployeeById(id);	
		logger.debug(emp);
		assertTrue(emp != null);
	}
	
//	@Test
	public void incrementSalaryTest(){
		int id = 1;		
		SalaryIncrement anotherIncrement = new SalaryIncrement(2000, new Date());
		Employee emp = service.incrementSalary(id, anotherIncrement);	
		assertSame(emp.getSalary(), 34354+2000);
	}
	
//	@Test
	public void findAllEmployees(){
		List<Employee> employees= service.findAllEmployees();
		System.out.println(employees);
		for(Employee emp: employees){
			System.out.println(emp.getIncrements());
		}
		assertTrue(true);
	}
}
