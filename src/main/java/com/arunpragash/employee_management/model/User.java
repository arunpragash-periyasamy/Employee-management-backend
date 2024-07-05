package com.arunpragash.employee_management.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private String userType;
}
