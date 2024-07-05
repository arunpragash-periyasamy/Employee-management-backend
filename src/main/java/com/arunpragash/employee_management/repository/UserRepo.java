package com.arunpragash.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arunpragash.employee_management.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public List<User> findByEmail(String email);
}
