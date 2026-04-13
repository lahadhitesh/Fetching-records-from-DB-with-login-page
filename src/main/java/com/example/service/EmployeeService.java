package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	// getById
	public Employee getEmployeeById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this " + id + " id"));// .orElse(null);
	}

	// getAllId
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	// save
	public Employee saveEmployee(Employee emp) {
		return repo.save(emp);
	}

	// saveAll
	public List<Employee> saveAllEmployees(List<Employee> employees) {
		return repo.saveAll(employees);
	}

	// UpdateById
	public Employee updateEmployeebyId(Long id, Employee emp) {

		Employee existing = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this " + id + " id"));

		existing.setFirstName(emp.getFirstName());
		existing.setLastName(emp.getLastName());
		existing.setEmail(emp.getEmail());
		existing.setSalary(emp.getSalary());

		return repo.save(existing);
	}

	public Employee patchEmployeeById(Long id, Employee emp) {

		Employee existing = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found with this id Id" + id));

		if (emp.getFirstName() != null) {
			existing.setFirstName(emp.getFirstName());
		}

		if (emp.getLastName() != null) {
			existing.setLastName(emp.getLastName());
		}

		if (emp.getEmail() != null) {
			existing.setEmail(emp.getEmail());
		}

		if (emp.getSalary() != 0.0) {
			existing.setSalary(emp.getSalary());
		}
		return repo.save(existing);
	}

	// DeleteById
	public String deleteEmployeeById(Long id) {
		repo.deleteById(id);
		return "Record deleted successfully...from service layer";
	}

	// DeleteById
	public String deleteAllEmployees() {
		repo.deleteAll();
		return "All Records deleted successfully...from service layer";
	}
}
