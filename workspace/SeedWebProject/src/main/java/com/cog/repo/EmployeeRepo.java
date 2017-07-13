package com.cog.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cog.entity.Employee;


@Repository
public class EmployeeRepo {
	
	final double MINIMUM_SALARY = 10000;
	
//	hibernate.cfg.xml   ->   persistence.xml
//	SessionFactory 		-> 	 EntityManagerFactory
//	Session				->   EntityManager		
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public boolean addEmployee(Employee emp) {
		//DB Code
		// session.save(emp);
		em.persist(emp);
		return true;
	}
	@Transactional
	public Employee updateSalary(int id, double newSalary) {
		Employee emp = em.find(Employee.class, id);
		emp.setSalary(newSalary);
		return emp;
	}
	public List<Employee> findEmployeesBelowMinimumSalary() {
		Query query = em.createQuery("select e from Employee e where e.salary < :minsalary");
		query.setParameter("minsalary", MINIMUM_SALARY);
		List<Employee> employees = query.getResultList();
		return employees;
	}
	
	

}
