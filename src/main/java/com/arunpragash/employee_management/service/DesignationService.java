package com.arunpragash.employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arunpragash.employee_management.model.Department;
import com.arunpragash.employee_management.model.Designation;
import com.arunpragash.employee_management.repository.DesignationRepo;

@Service
public class DesignationService {

    @Autowired
    DesignationRepo repo;

    public List<Designation> getDesignations() {
        return repo.findAll();
    }  

    public boolean addDesignation(Designation designation) {
        try {
            repo.save(designation);
            return true;
        } catch (Exception exception) {
            System.out.println("Error in adding designation " + exception.getMessage());
            return false;
        }
    }

    public boolean updateDesignation(Designation designation) {
    try {
        Optional<Designation> existingDesignation = repo.findById(designation.getId());
        
        if (existingDesignation.isPresent()) {
            repo.save(designation);
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


    public boolean deleteDesignation(Integer designationId) {
        try {
            repo.deleteById(designationId);
            return true;
        } catch (Exception exception) {
            System.out.println("Error in deleting designation " + exception.getMessage());
            return false;
        }
    }

    public Designation getDesignation(Integer designationId) {
       return repo.findById(designationId).get(); 
    }

}
