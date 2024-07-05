package com.arunpragash.employee_management.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arunpragash.employee_management.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
