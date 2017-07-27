package com.cts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;
import com.cts.entity.SalaryIncrement;

@Repository
public class IncrementDAO {
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public boolean addEmployee(Employee emp) {
		em.persist(emp);
		return true;
	}

	@Transactional
	public Employee findEmployeeById(int id) {
		Employee emp = em.find(Employee.class, id);
		System.out.println(emp);
		System.out.println(emp.getIncrements());
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
