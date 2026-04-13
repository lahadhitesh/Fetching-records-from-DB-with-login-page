package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeViewController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/view")
	public String viewEmployees(Model model) {
		System.out.println("Controller Hit"); // DEBUG
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("employees", list);
		return "employee"; // home.jsp
	}
}