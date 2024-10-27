package com.codewa.empmngtsbtm.service;

import com.codewa.empmngtsbtm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
}
