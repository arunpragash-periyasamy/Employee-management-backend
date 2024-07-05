package com.arunpragash.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunpragash.employee_management.model.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public boolean addOrUpdateEmployee(Employee employee) {
        try {
            repo.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Employee getEmployee(Integer employeeId) {
        return repo.findById(employeeId).orElse(new Employee());
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
        return repo.findAll();
    }

}
