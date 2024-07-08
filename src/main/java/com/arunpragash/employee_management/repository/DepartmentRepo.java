package com.arunpragash.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arunpragash.employee_management.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {


}
