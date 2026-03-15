package com.main.controller;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;
import com.main.repository.EmployeeRepository;
import com.main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeID) {
        return employeeService.getEmployeeById(employeeID);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createEmployee(employeeEntity);
    }
}