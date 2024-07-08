package com.arunpragash.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arunpragash.employee_management.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query("select e from Employee e where e.empId = ?1 and e.password = ?2")
    Employee findByEmpIdAndPassword(String empId, String password);
}
