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

import com.arunpragash.employee_management.model.Designation;
import com.arunpragash.employee_management.service.DesignationService;

@RestController
@RequestMapping("/api/designation")
@CrossOrigin("*")
public class DesignationController {
    @Autowired
    private DesignationService service;

    @GetMapping
    public List<Designation> getDesignations() {
        return service.getDesignations();
    }

    @PostMapping
    public boolean addDesignation(@RequestBody Designation designation) {
        return service.addDesignation(designation);
    }

    @PutMapping("{id}")
    public boolean updateDesignation(@RequestBody Designation designation, @PathVariable long id) {
        return service.updateDesignation(designation);
    }

    @DeleteMapping("{designationId}")
    public boolean deleteDesignation(@PathVariable Integer designationId) {
        return service.deleteDesignation(designationId);
    }

    @GetMapping("{designationId}")
    public Designation getDesignation(@PathVariable Integer designationId) {
        return service.getDesignation(designationId);
    }

}