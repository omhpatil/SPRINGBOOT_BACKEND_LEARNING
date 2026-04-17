package com.main.controller;

import com.main.dto.EmployeeDTO;
import com.main.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Here i have made change for checking jenkins pipeline is working correct or not

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO created = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeDTO employeeDTO) {

        Optional<EmployeeDTO> updated = employeeService.updateEmployee(id, employeeDTO);

        return updated
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {

        boolean deleted = employeeService.deleteEmployee(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        Optional<EmployeeDTO> updatedEmployee =
                employeeService.updatePartialEmployeeById(id, updates);

        return updatedEmployee
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}