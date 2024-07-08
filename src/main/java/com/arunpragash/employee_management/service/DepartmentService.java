package com.arunpragash.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunpragash.employee_management.model.Department;
import com.arunpragash.employee_management.repository.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo repo;

    public List<Department> getDepartments() {
        return repo.findAll();
    }

    public boolean addDepartment(Department department) {
        try {
            System.out.println(department.getId());
            repo.save(department);
            return true;
        }
        catch (Exception e) {
                System.out.println("Department Add error " + e.getMessage());
                return false;
            }
    }

    public boolean updateDepartment(Department department) {
        try {
            Optional<Department> existingDepartment = repo.findById(department.getId());

            if (existingDepartment.isPresent()) {
                repo.save(department);
                return true;
            } else {
                System.out.println("Department not found for update");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Department Update error: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteDepartment(Integer departmentId) {
        try{
            repo.deleteById(departmentId);
            return true;
        }
        catch (Exception e) {
                System.out.println("Department Delete error " + e.getMessage());
                return false;
            }
    }

    public Department getDepartment(Integer departmentId) {
        return repo.findById(departmentId).get();
    }

}
