package com.cog.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cog.entity.Address;
import com.cog.entity.Employee;
import com.cog.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/beans.xml")
public class EmployeeTest {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	EmployeeService service;

//	@Test
	public void test() {
		Employee emp = new Employee("Amit", 4455);
		
		
		Address officeAddress = new Address(34, "Hinjewadi", "Pune");
		officeAddress.setEmployee(emp);
		Address residenceAddress = new Address(334, "Wakad", "Pune");
		residenceAddress.setEmployee(emp);
		List<Address> addresses = new ArrayList<>();
		addresses.add(residenceAddress);
		addresses.add(officeAddress);
		
		
		emp.setAddresses(addresses);
		
		
		
		boolean result = service.addEmployee(emp);
		
		
		emp.setName("XYZ");// EMp is in detached state
		logger.debug(result);
		System.out.println(result);
		assertTrue(result);
	}
	
	
	@Test
	public void findByEmployeeId(){
		int id = 1;
		Employee emp = service.findEmployeeById(id);
		logger.debug(emp);
		System.out.println(emp);
		logger.debug(emp.getAddresses().get(1).getLocality());
		assertTrue(true);
	}
	
//	@Test
	public void testUpdateSalary() {
		int id = 2;
		double newSalary = 5656;
		Employee emp = service.updateSalary(id, newSalary);
		assertEquals(newSalary, emp.getSalary(), 0.5);
	}
	
//	@Test(expected=RuntimeException.class)
	public void testUpdateSalaryWithNegativeSalary() {
		int id = 2;
		double newSalary = -3453;
		try{
			Employee emp = service.updateSalary(id, newSalary);
		}catch(RuntimeException re){
			re.printStackTrace();
			throw re;
		}
		
//		assertEquals(newSalary, emp.getSalary(), 0.5);
	}
	
//	@Test
	public void testMinimumSalary(){
		List<Employee> employees = service.findEmployeesBelowMinimumSalary();
		System.out.println(employees);
		assertSame(1, employees.size());
	}
	
	

}
