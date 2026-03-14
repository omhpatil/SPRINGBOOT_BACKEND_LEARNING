package com.main.repository;

import com.main.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    // here we are not extending the CrudRepository because JpaRepository internally uses CrudRepository.

}
