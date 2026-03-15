package com.main.service;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;
import com.main.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,  ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long employeeID) {
        EmployeeEntity employeeEntity =  employeeRepository.findById(employeeID).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntity =  employeeRepository.findAll();
        return modelMapper.map(employeeEntity, List.class);
    }


    public EmployeeDTO createEmployee(EmployeeEntity employeeDTO) {
        EmployeeEntity toSaveEmployeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEmployeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
