package com.codewa.empmngtsbtm.service;

import com.codewa.empmngtsbtm.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployee(long id);
    Page<Employee> pagination(int pageNo, int size, String sortField, String sortDirection);
}
