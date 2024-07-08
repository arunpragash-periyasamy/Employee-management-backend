package com.arunpragash.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunpragash.employee_management.model.Employee;
import com.arunpragash.employee_management.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public boolean addEmployee(Employee employee) {
        try {
            repo.save(employee); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateEmployee(Employee employee) {
    try {
        Optional<Employee> existingEmployee = repo.findById(employee.getId());
        
        if (existingEmployee.isPresent()) {
            repo.save(employee);
            return true;
        } else {
            System.out.println("Employee not found for update");
            return false;
        }
    } catch (Exception e) {
        System.out.println("Employee Update error: " + e.getMessage());
        return false;
    }
}


    public Employee getEmployee(Integer employeeId) {
        return repo.findById(employeeId).get(); 
    }

    public boolean deleteEmployee(Integer employeeId) {
        try{
            repo.deleteById(employeeId);
            return true;
        } catch (Exception exception) {
            System.out.println("Delete error in the Employee " + exception.getMessage());
            return false;
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = repo.findAll();

        // Remove the password field from each employee object

        employees.forEach(employee -> {
            employee.setPassword(null);
        });
        return employees;
    }

    public boolean login(String empId, String password) {
        Employee employee = repo.findByEmpIdAndPassword(empId, password);
        if (employee != null) {
            System.out.println("Employee found: " + employee);
            return true; // Login successful
        } else {
            System.out.println("Employee not found or incorrect credentials.");
            return false; // Login failed
        }
    }

}
