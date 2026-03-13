package com.main.controller;

import com.main.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping("/display")WW
//    public String display(){
//        return "First Rest Api";
//    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeID(@PathVariable Long employeeID) {
        return new EmployeeDTO(employeeID, "Om", "omhpatil@gmail.com", 25, LocalDate.of(2026, 3, 13), true);
    }

    @GetMapping
    public EmployeeDTO getEmployeeIDs(@RequestParam Long employeeID) {
        return new EmployeeDTO(employeeID, "Om", "omhpatil@gmail.com", 25, LocalDate.of(2026, 3, 13), true);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(1);
        return inputEmployee;
    }

}
