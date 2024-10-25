package com.codewa.empmngtsbtm.repository;

import com.codewa.empmngtsbtm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
