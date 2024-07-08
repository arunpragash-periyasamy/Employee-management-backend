package com.arunpragash.employee_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunpragash.employee_management.model.Department;
import com.arunpragash.employee_management.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<Department> getDepartments() {
        return service.getDepartments();
    }

    @PostMapping
    public boolean addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @PutMapping("{id}")
    public boolean updateDepartment(@RequestBody Department department, @PathVariable long id) {
        return service.updateDepartment(department);
    }

    @DeleteMapping("{departmentId}")
    public boolean deleteDepartment(@PathVariable Integer departmentId) {
        return service.deleteDepartment(departmentId);
    }

    @GetMapping("{departmentId}")
    public Department getDepartment(@PathVariable Integer departmentId) {
        return service.getDepartment(departmentId);
    }

}