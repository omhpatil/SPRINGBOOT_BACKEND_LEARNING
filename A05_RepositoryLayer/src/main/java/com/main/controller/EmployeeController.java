package com.main.controller;

import com.main.entity.EmployeeEntity;
import com.main.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get Employee by ID
    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeID) {
        return employeeRepository.findById(employeeID).orElse(null);
    }

    // Get All Employees
    @GetMapping
    public List<EmployeeEntity> getEmployees() {
        return employeeRepository.findAll();
    }

    // Create Employee
    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

}