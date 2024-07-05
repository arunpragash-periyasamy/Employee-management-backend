package com.arunpragash.employee_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arunpragash.employee_management.model.User;
import com.arunpragash.employee_management.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/users")
    public List<User> users() {
        return service.getUsers();
    }

    @GetMapping("/test")
    public String test() {
        return "Testing";
    }
    @GetMapping("/")
    public String home() {
        return "Welcome to the employee management system";
    }
}
