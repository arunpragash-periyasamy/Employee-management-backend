package com.arunpragash.employee_management;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
