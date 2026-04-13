package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
