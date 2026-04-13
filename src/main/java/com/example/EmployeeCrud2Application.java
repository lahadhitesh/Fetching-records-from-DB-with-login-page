package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmployeeCrud2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrud2Application.class, args);
	}

}
