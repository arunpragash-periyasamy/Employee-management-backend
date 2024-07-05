package com.arunpragash.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunpragash.employee_management.model.Employee;
import com.arunpragash.employee_management.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping
    public String home() {
        return "Welcome to the employee management system";
    }

    @PostMapping("")
    public boolean addEmployee(@RequestBody Employee employee) {
        return service.addOrUpdateEmployee(employee);
    }

    @PutMapping
    public boolean updateEmployee(@RequestBody Employee employee) {
        return service.addOrUpdateEmployee(employee);
    }

    @DeleteMapping("{employeeId}")
    public boolean deleteEmployee(@PathVariable Integer employeeId) {
        return service.deleteEmployee(employeeId);
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {
        return service.getEmployee(employeeId);
    }

    @GetMapping("/employees")

    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }
}
