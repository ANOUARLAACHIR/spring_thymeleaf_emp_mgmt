package com.codewa.empmngtsbtm.impl;

import com.codewa.empmngtsbtm.entity.Employee;
import com.codewa.empmngtsbtm.repository.EmployeeRepository;
import com.codewa.empmngtsbtm.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpoyeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmpoyeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("employee not found");
    }
}
