package com.cog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cog.entity.Address;
import com.cog.entity.Employee;
import com.cog.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String addEmployee() {

		Employee emp = new Employee("Amit-MVC", 4455);

		Address officeAddress = new Address(34, "Hinjewadi-MVC", "Pune");
		officeAddress.setEmployee(emp);
		Address residenceAddress = new Address(334, "Wakad-MVC", "Pune");
		residenceAddress.setEmployee(emp);
		List<Address> addresses = new ArrayList<>();
		addresses.add(residenceAddress);
		addresses.add(officeAddress);

		emp.setAddresses(addresses);

		boolean result = service.addEmployee(emp);
		if (result) {
			return "success";
		}
		return "error";

	}
	
	
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee2(@RequestParam("name") String name, @RequestParam("salary") double salary, Model model) {
		Employee emp = new Employee(name, salary);
		boolean result = service.addEmployee(emp);
		if (result) {
			model.addAttribute("username", name);
			return "success";
		}
		return "error";

	}

}
