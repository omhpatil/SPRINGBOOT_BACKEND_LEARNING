package com.main.service;

import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;
import com.main.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity saved = employeeRepository.save(entity);
        return modelMapper.map(saved, EmployeeDTO.class);
    }

    public Optional<EmployeeDTO> updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isEmpty()) {
            return Optional.empty();
        }
        EmployeeEntity entity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        entity.setId(id);
        EmployeeEntity saved = employeeRepository.save(entity);
        return Optional.of(modelMapper.map(saved, EmployeeDTO.class));
    }

    public boolean deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    public Optional<EmployeeDTO> updatePartialEmployeeById(Long id, Map<String, Object> updates) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            return Optional.empty();
        }
        EmployeeEntity employeeEntity = optionalEmployee.get();
        updates.forEach((fieldName, value) -> {
            Field field = ReflectionUtils
                    .findField(EmployeeEntity.class, fieldName);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, employeeEntity, value);
            }
        });
        EmployeeEntity saved = employeeRepository.save(employeeEntity);
        return Optional.of(modelMapper.map(saved, EmployeeDTO.class));
    }
}