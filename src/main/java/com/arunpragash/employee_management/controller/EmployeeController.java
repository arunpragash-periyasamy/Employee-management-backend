package com.arunpragash.employee_management.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public boolean addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    

    @PutMapping("{id}")
    public boolean updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
        return service.updateEmployee(employee);
    }

    @DeleteMapping("{employeeId}")
    public boolean deleteEmployee(@PathVariable Integer employeeId) {
        return service.deleteEmployee(employeeId);
    }

    @GetMapping("{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId) {
        return service.getEmployee(employeeId);
    }

  

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        String empId = loginDetails.get("empId");
        String password = loginDetails.get("password");

        boolean loginSuccessful = service.login(empId, password);

        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }

}