package com.cts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;
import com.cts.entity.SalaryIncrement;

@Repository
public class IncrementDAO {
	@PersistenceContext
	EntityManager em;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Transactional
	public boolean addEmployee(Employee emp) {
		em.persist(emp);
		return true;
	}

	@Transactional
	public Employee findEmployeeById(int id) {
		Employee emp = null;
		try{
			
			emp = em.find(Employee.class, id);
			emp.getIncrements();
		}
		catch(Exception e){
			logger.error(e.getMessage());
		}
		
		logger.debug(emp);
		logger.debug(emp.getIncrements());
		return emp;
	}

	@Transactional
	public Employee incrementSalary(int id, SalaryIncrement anotherIncrement) {
		Employee emp = em.find(Employee.class, id);
		anotherIncrement.setEmployee(emp);
		emp.setSalary(emp.getSalary() + anotherIncrement.getAmount());
		emp.getIncrements().add(anotherIncrement);
		return emp;
	}

	@Transactional
	public List<Employee> findEmployees() {
		Query query = em.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		for(Employee emp: employees){
			System.out.println(emp.getIncrements());
		}
		return employees;
	}

}
