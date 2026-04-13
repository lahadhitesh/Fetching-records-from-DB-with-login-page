package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("mapping")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// 1
	@GetMapping("/{id}")
	public Employee findByid(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}

	// 2
	@GetMapping
	public List<Employee> findAll() {
		return service.getAllEmployee();
	}

	// 3
	@PostMapping("/{bulk}")
	public List<Employee> saveAll(@RequestBody List<Employee> employees) {
		return service.saveAllEmployees(employees);
	}

	// 4
	@PostMapping
	public Employee save(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}

	// 5
	@PutMapping("/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
		return service.updateEmployeebyId(id, emp);
	}

	// 6
	@PatchMapping("/{id}")
	public Employee patch(@PathVariable Long id, @RequestBody Employee emp) {
		return service.patchEmployeeById(id, emp);
	}

	// 7
	// DeleteById
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteEmployeeById(id);
	}

	// 8
	// DeleteAllId
	@DeleteMapping()
	public void deleteAllEmployees() {
		service.deleteAllEmployees();
	}
}
