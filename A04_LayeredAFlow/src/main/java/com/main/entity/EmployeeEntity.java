package com.main.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private Integer age;

    private LocalDate dob;

    private Boolean isActive;
}
