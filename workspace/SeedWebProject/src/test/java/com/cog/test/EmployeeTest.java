package com.cog.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	EmployeeService service;

//	@Test
	public void test() {
		Address officeAddress = new Address(34, "Hinjewadi", "Pune");
		Address residenceAddress = new Address(334, "Wakad", "Pune");
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(residenceAddress);
		addresses.add(officeAddress);
		
		Employee emp = new Employee("Amit", 4455);
		emp.setAddresses(addresses);
		
		
		
		boolean result = service.addEmployee(emp);
		
		
		emp.setName("XYZ");// EMp is in detached state
		System.out.println(result);
		assertTrue(result);
	}
	
	
	@Test
	public void findByEmployeeId(){
		int id = 1;
		Employee emp = service.findEmployeeById(id);
		System.out.println(emp);
		System.out.println(emp.getAddresses().get(1).getLocality());
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
