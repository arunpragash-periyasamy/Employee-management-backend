package com.arunpragash.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunpragash.employee_management.model.User;
import com.arunpragash.employee_management.repository.UserRepo;
@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    
    public List<User> getUsers() {
        return repo.findAll();
    }
    

    public boolean addUser(User user) {
        try {
            if (repo.existsById(user.getId())) {
                return false;
            }
            repo.save(user);
            return true;
        } catch (Exception exception) {
            System.out.println("Adding user has an exception " + exception.getMessage());
            return false;
        }
    }
    
    public void getUser() {
        System.out.println(repo.findByEmail("arunpragash46@gmail.com"));
    }
}
